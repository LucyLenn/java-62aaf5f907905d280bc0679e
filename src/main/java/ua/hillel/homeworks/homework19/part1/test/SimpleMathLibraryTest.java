package ua.hillel.homeworks.homework19.part1.test;

import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework19.part1.SimpleMathLibrary;

public class SimpleMathLibraryTest {
    private SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();

    @Test
    void testAdd() {
        if (simpleMathLibrary.add(6, 6) == 12) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    @Test
    void testMinus() {
        if (simpleMathLibrary.minus(16, 6) == 10) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }
}
