package ua.hillel.homeworks.homewoks22.server;

import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.server.ClientSession;
import ua.hillel.homeworks.homework22.server.SessionsManager;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ClientSessionTest {

    @Test
    void shouldCreateClientSession_NotNull() {
        Socket mockSocket = mock(Socket.class);
        assertNotNull(new ClientSession(mockSocket, "client-test", new SessionsManager()));
    }
}
