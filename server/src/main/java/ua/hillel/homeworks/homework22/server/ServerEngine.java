package ua.hillel.homeworks.homework22.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEngine {
    private static final Logger log = LogManager.getLogger(ServerEngine.class);
    private static final int SERVER_PORT = 8888;

    private final SessionsManager sessionsManager = new SessionsManager();
    private int connections;

    public ServerEngine() {
        log.info("Server is about to start");

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            log.info(
                    "Server is up and running on: {}:{}",
                    serverSocket.getInetAddress().getHostName(),
                    serverSocket.getLocalPort()
            );

            while (true) {
                Socket client = serverSocket.accept();
                String clientName = "Client-" + ++connections;

                new Thread(() -> {
                    ClientSession clientSession = new ClientSession(client, clientName, sessionsManager);
                    log.info("The client successfully connected: {}", client.getRemoteSocketAddress());
                    sessionsManager.sendMessageToAll(clientName + " successfully connected");
                    sessionsManager.addSession(clientSession);
                });
            }

        } catch (IOException e) {
            log.error("Error in working with server connection", e);
            throw new RuntimeException("Error in working with server connection", e);
        }
    }
}
