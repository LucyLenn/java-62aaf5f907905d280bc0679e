package ua.hillel.homeworks.homewoks22.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.server.ServerEngine;

class ServerEngineTest {

    @Test
    void shouldThrowRuntimeException_whenConnectionRefused() {
        Assertions.assertThrowsExactly(RuntimeException.class,
                () -> new ServerEngine());
    }
}
