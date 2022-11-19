package ua.hillel.homeworks.homewoks22.server;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.server.ClientSession;
import ua.hillel.homeworks.homework22.server.SessionsManager;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SessionManagerTest {

    @Test
    @SneakyThrows
    public void testAddSession() {
        SessionsManager sessionsManager= new SessionsManager();

        ClientSession clientSession = new ClientSession(
                new Socket("localhost", 8888), "client-test", sessionsManager);
        sessionsManager.addSession(clientSession);
        List<ClientSession> expected = sessionsManager.getActiveClients();

        List<ClientSession> actual = new ArrayList<>();
        actual.add(clientSession);

        Assertions.assertEquals(expected,actual);
    }
}
