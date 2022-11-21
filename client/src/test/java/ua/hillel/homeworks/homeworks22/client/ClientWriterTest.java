package ua.hillel.homeworks.homeworks22.client;

import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.client.ClientWriter;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ClientWriterTest {

    @Test
    void shouldCreateClientWriter_NotNull() {
        Socket mockSocket = mock(Socket.class);
        assertNotNull(new ClientWriter(mockSocket));
    }
}
