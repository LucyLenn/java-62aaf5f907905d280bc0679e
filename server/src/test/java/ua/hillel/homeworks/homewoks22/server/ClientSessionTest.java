package ua.hillel.homeworks.homewoks22.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.server.ClientSession;
import ua.hillel.homeworks.homework22.server.SessionsManager;

import java.net.Socket;

public class ClientSessionTest {

    @Test
    public void testThrowRuntimeException_whenCanNotCreateIOStream() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new ClientSession(new Socket(), "client-test", new SessionsManager()));
    }
}
