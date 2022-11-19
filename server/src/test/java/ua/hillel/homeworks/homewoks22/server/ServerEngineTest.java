package ua.hillel.homeworks.homewoks22.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.server.ServerEngine;

public class ServerEngineTest {

    @Test
    public void testThrowRuntimeException_whenConnectionRefused() {
        Assertions.assertThrowsExactly(RuntimeException.class,
                () -> new ServerEngine());
    }

}
