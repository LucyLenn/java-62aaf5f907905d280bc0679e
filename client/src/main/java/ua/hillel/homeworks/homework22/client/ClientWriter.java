package ua.hillel.homeworks.homework22.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientWriter implements Runnable {
    private static final Logger log = LogManager.getLogger(ClientWriter.class);
    private final Socket socket;
    private DataOutputStream out;

    public ClientWriter(Socket socket) {
        this.socket = socket;

        try {
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            log.error("Error in creating I/O Stream", e);
            closeStreams();
        }
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String outboundMessage = br.readLine();
                out.writeUTF(outboundMessage);
                out.flush();

                if (outboundMessage.equalsIgnoreCase("-exit")) {
                    log.info("Client input message to disconnect: {}", outboundMessage);
                    break;
                }
                if (outboundMessage.startsWith("-file")) {
                    log.info("Client input message to copy file: {}", outboundMessage);
                }
            }
        } catch (IOException e) {
            log.error("Error in writing message to server from console", e);
        }
    }

    private void closeStreams() {
        try {
            out.close();
        } catch (IOException e) {
            log.error("Error in closing OutStream", e);
        }
    }
}
