package ua.hillel.homeworks.homework22.client;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientEngine {

    private static final Logger log = LogManager.getLogger(ClientEngine.class);
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;

    private final Socket socket;
    private final DataInputStream dataIn;
    private final DataOutputStream dataOut;

    @SneakyThrows
    public ClientEngine() {
        log.info("Client is about to start ...");
        socket = new Socket(SERVER_HOST, SERVER_PORT);
        log.info(
                "Client is up and running on: {}:{}",
                socket.getInetAddress().getHostName(),
                socket.getLocalPort()
        );

        log.info("The client successfully connected: {}", socket.getRemoteSocketAddress());

        dataIn = new DataInputStream(socket.getInputStream());
        dataOut = new DataOutputStream(socket.getOutputStream());

        dataOut.writeUTF("Hello");
        String inboundMessage = dataIn.readUTF();
        System.out.println("Server response: " + inboundMessage);

    }
}
