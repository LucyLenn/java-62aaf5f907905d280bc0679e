package ua.hillel.homeworks.homeworks22.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.client.ClientEngine;

class ClientEngineTest {

    @Test
    void shouldThrowRuntimeException_whenConnectionRefused() {
        Assertions.assertThrowsExactly(RuntimeException.class,
                () -> new ClientEngine());
    }
}

