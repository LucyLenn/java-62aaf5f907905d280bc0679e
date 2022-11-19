package ua.hillel.homeworks.homework22.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientEngine {
    private static final Logger log = LogManager.getLogger(ClientEngine.class);
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;

    public ClientEngine() {
        log.info("Client is about to start ...");

        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             DataInputStream in = new DataInputStream(socket.getInputStream())
        ) {
            log.info("The client successfully connected: {}", socket.getRemoteSocketAddress());

            new Thread(new ClientWriter(socket)).start();

            while (true) {
                String inboundMessage = in.readUTF();

                if (inboundMessage.equalsIgnoreCase("-exit")) {
                    break;
                }
                System.out.println("Server message: " + inboundMessage);
            }
        } catch (IOException e) {
            log.error("Error in working with client session", e);
            throw new RuntimeException("Error in working with client session", e);
        }
    }
}
