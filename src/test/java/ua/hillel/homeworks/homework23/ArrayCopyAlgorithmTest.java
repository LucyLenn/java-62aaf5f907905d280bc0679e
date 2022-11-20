package ua.hillel.homeworks.homework23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArrayCopyAlgorithmTest {

    ArrayCopyAlgorithm copyingAlgorithm = new ArrayCopyAlgorithm();

    @ParameterizedTest
    @MethodSource("sourceAndTargetNullArraysProvider")
    void shouldThrowRuntimeException_ifSourceOrTargetArrayEqualsNull(int[] sourceArray, int[] targetArray) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> copyingAlgorithm.arrayCopy(sourceArray, targetArray));
    }

    static Stream<Arguments> sourceAndTargetNullArraysProvider() {
        return Stream.of(
                Arguments.of(null, new int[]{ 5, 6, 7 }),
                Arguments.of(new int[]{ 1, 2, 3, 4 }, null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceAndTargetArraysProvider")
    void shouldRetrieveResultOfMergingTwoArrays(int[] sourceArray, int[] targetArray, int[] resultArray) {
        Assertions.assertArrayEquals(copyingAlgorithm.arrayCopy(sourceArray, targetArray), resultArray);
    }

    static Stream<Arguments> sourceAndTargetArraysProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{ 1, 2, 3, 4 }, new int[]{}, new int[]{ 1, 2, 3, 4 }),
                Arguments.of(new int[]{}, new int[]{ 1, 2, 3, 4 }, new int[]{ 1, 2, 3, 4 }),
                Arguments.of(new int[]{ 1, 2, 3, 4 }, new int[]{ 5, 6, 7 }, new int[]{ 5, 6, 7, 1, 2, 3, 4 })
        );
    }
}
