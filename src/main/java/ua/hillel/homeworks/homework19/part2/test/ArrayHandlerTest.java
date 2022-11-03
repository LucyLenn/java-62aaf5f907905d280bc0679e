package ua.hillel.homeworks.homework19.part2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static ua.hillel.homeworks.homework19.part2.ArrayHandler.checkArrayForOneAndFour;
import static ua.hillel.homeworks.homework19.part2.ArrayHandler.getValuesAfterLastFour;

public class ArrayHandlerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowRuntimeException_whenNullOrEmptyArray_inGetValuesAfterLast4(int[] emptyArray) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> getValuesAfterLastFour(emptyArray));
    }

    @Test
    void shouldThrowRuntimeException_whenNotFoundNumberFour() {
        int[] inputArray = { 6, 7, 8, 9 };
        Assertions.assertThrowsExactly(RuntimeException.class, () -> getValuesAfterLastFour(inputArray));
    }

    @ParameterizedTest
    @MethodSource("provideArraysForRetrieveArrayPartAfterLatestFour")
    void shouldRetrieveArrayPart_afterLatestFourValueFound(int[] inputArray, int[] expectedArray) {
        Assertions.assertArrayEquals(expectedArray, getValuesAfterLastFour(inputArray));
    }

    private static Stream<Arguments> provideArraysForRetrieveArrayPartAfterLatestFour() {
        return Stream.of(
                Arguments.of(new int[]{ 1, 2, 3, 4 }, new int[0]),
                Arguments.of(new int[]{ 4, 3, 2, 1 }, new int[]{ 3, 2, 1 }),
                Arguments.of(new int[]{ 1, 2, 4, 4, 2, 3, 4, 1, 7 }, new int[]{ 1, 7 })
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowRuntimeException_whenNullOrEmptyArray_inCheckArrayForOneAndFour(int[] emptyArray) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> checkArrayForOneAndFour(emptyArray));
    }

    @Test
    void shouldReturnTrue_whenOneAndFourArePresent() {
        int[] validIntegerArray = { 1, 1, 1, 4, 4, 1, 4, 4 };
        Assertions.assertTrue(checkArrayForOneAndFour(validIntegerArray));
    }

    @Test
    void shouldReturnFalse_whenFourNotFound() {
        int[] integerArrayWithOneNumberOnly = { 1, 1, 1, 1, 1, 1 };
        Assertions.assertFalse(checkArrayForOneAndFour(integerArrayWithOneNumberOnly));
    }

    @Test
    void shouldReturnFalse_whenOneNotFound() {
        int[] integerArrayWithFourNumberOnly = { 4, 4, 4, 4 };
        Assertions.assertFalse(checkArrayForOneAndFour(integerArrayWithFourNumberOnly));
    }

    @Test
    void shouldReturnFalse_whenOneAndFourWithRandomDigitsArePresent() {
        int[] integerArrayWithOtherNumber = { 1, 4, 4, 1, 1, 4, 3 };
        Assertions.assertFalse(checkArrayForOneAndFour(integerArrayWithOtherNumber));
    }
}
