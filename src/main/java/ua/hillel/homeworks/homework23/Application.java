package ua.hillel.homeworks.homework23;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        sortArrayExample();
        copyArrayExample();
    }

    static void sortArrayExample() {
        Integer[] arrayInteger = new Integer[]{ 84, 7, 8, 22, 12, 6, 4, 15 };

        CocktailShakerSort<Integer> sortingAlgorithm = new CocktailShakerSort<>();
        sortingAlgorithm.shakerSort(arrayInteger);

        System.out.println(Arrays.toString(arrayInteger));
    }

    static void copyArrayExample() {
        int[] sourceArray = new int[]{ 1, 2, 3, 4, 5 };
        int[] targetArray = new int[]{};

        ArrayCopyAlgorithm copyingAlgorithm = new ArrayCopyAlgorithm();
        int[] result = copyingAlgorithm.arrayCopy(sourceArray, targetArray);

        System.out.println(Arrays.toString(result));
    }
}
