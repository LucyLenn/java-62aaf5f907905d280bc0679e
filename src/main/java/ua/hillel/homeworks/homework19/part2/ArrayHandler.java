package ua.hillel.homeworks.homework19.part2;

import java.util.Arrays;

public class ArrayHandler {
    public static int[] getValuesAfterLastFour(int[] integerArray) {
        if (integerArray == null || integerArray.length == 0) {
            throw new RuntimeException("Array must not be null or empty.");
        }

        for (int i = integerArray.length - 1; i >= 0; i--) {
            if (integerArray[i] == 4) {
                return Arrays.copyOfRange(integerArray, i + 1, integerArray.length);
            }
        }
        throw new RuntimeException("Array does not contain the digit 4.");
    }

    public static boolean checkArrayForOneAndFour(int[] integerArray) {
        if (integerArray == null || integerArray.length == 0) {
            throw new RuntimeException("Array must not be null or empty.");
        }

        return Arrays.stream(integerArray).anyMatch(x -> x == 4)
                && Arrays.stream(integerArray).anyMatch(x -> x == 1)
                && Arrays.stream(integerArray).noneMatch(x -> (x != 4 && x != 1));
    }
}
