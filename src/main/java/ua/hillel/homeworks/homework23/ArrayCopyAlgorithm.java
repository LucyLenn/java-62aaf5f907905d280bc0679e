package ua.hillel.homeworks.homework23;

public class ArrayCopyAlgorithm {

    public int[] arrayCopy(int[] sourceArray, int[] targetArray) {

        if (sourceArray == null || targetArray == null) {
            throw new RuntimeException("Array (source and/or target) must not be null.");
        }

        int resultArrayLength = sourceArray.length + targetArray.length;
        int[] resultArray = new int[resultArrayLength];

        if (targetArray.length == 0) {
            resultArray = sourceArray;
            return resultArray;
        }

        for (int i = 0; i < resultArrayLength; i++) {
            if (i < targetArray.length) {
                resultArray[i] = targetArray[i];
            } else {
                resultArray[i] = sourceArray[i - targetArray.length];
            }
        }
        return resultArray;
    }

}
