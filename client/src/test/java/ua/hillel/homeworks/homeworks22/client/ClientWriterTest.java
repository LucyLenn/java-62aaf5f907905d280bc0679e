package ua.hillel.homeworks.homeworks22.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.client.ClientWriter;

import java.io.IOException;
import java.net.Socket;

public class ClientWriterTest {

    @Test
    public void testThrowIOException_whenConnectionRefused() {
        Assertions.assertThrows(IOException.class,
                () -> new ClientWriter(new Socket("localhost", 8888)).run());
    }
}
