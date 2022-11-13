package ua.hillel.homeworks.homework22.server;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;



public class ServerEngine {

    private static final Logger log = LogManager.getLogger(ServerEngine.class);
    private static final int SERVER_PORT = 8888;

    private final ServerSocket serverSocket;
    private final DataInputStream dataIn;
    private final DataOutputStream dataOut;

    @SneakyThrows
    public ServerEngine() {
        log.info("Server is about to start");
        serverSocket = new ServerSocket(SERVER_PORT);
        log.info(
                "Server is up and running on: {}:{}",
                serverSocket.getInetAddress().getHostName(),
                serverSocket.getLocalPort()
        );

        var client = serverSocket.accept();
        log.info("The client successfully connected: {}", client.getRemoteSocketAddress());

        dataIn = new DataInputStream(client.getInputStream());
        dataOut = new DataOutputStream(client.getOutputStream());

        String inboundMessage;
        inboundMessage = dataIn.readUTF();
        dataOut.writeUTF("Echo: " + inboundMessage);
    }

}
