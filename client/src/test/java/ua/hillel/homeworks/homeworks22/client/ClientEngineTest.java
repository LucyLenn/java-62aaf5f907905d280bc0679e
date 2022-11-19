package ua.hillel.homeworks.homeworks22.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework22.client.ClientEngine;

public class ClientEngineTest {

    @Test
    public void testThrowRuntimeException_whenConnectionRefused() {
        Assertions.assertThrowsExactly(RuntimeException.class,
                () -> new ClientEngine());
    }
}

