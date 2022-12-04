package ua.hillel.homeworks.homework22.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

public class ClientSession implements Runnable {
    private static final Logger log = LogManager.getLogger(ClientSession.class);
    private final Socket socket;
    private final String clientName;
    private final LocalDateTime timeConnection;
    private final SessionsManager sessionsManager;

    private DataOutputStream out;
    private DataInputStream in;

    public ClientSession(Socket socket, String clientName, SessionsManager sessionsManager) {
        this.socket = socket;
        this.clientName = clientName;
        this.sessionsManager = sessionsManager;
        timeConnection = LocalDateTime.now();

        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            log.error("Error in creating I/O Stream", e);
            closeStreams();
        }
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String inboundMessage = in.readUTF();

                if (inboundMessage.equalsIgnoreCase("-exit")) {
                    sessionsManager.removeSession(this);
                    log.info("{} initialize connection suicide...", clientName);
                    out.writeUTF(inboundMessage);
                    break;
                }
                if (inboundMessage.startsWith("-file")) {
                    new FileUploader().uploadFile(inboundMessage);
                    continue;
                }

                out.writeUTF(inboundMessage + " - OK");
                out.flush();
                log.info("Server wrote message to {}: {}", clientName, inboundMessage);
            }
            log.info("{} disconnected", clientName);

            closeStreams();
            socket.close();
            log.info("Closed connections & channels, {}", clientName);
        } catch (IOException e) {
            log.error("Error in working with client session {} on server", clientName, e);
            throw new RuntimeException(
                    String.format("Error in working with client session %s on server", clientName), e);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            log.error("Error in reading message from client: {}", clientName);
        }
    }

    private void closeStreams() {
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            log.error("Error in closing I/O Stream", e);
            throw new RuntimeException("Error with I/O Stream work", e);
        }

    }
}
