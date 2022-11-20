package ua.hillel.homeworks.homework23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CocktailShakerSortTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowRuntimeException_whenNullOrEmptyArray(Integer[] emptyArray) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> new CocktailShakerSort<Integer>().shakerSort(emptyArray));
    }

    @Test
    void shouldRetrieveSortedArray_forIntegerType() {
        Integer[] inputArray = new Integer[]{ 84, 7, 8, 22, 12, 6, 4, 15 };
        Integer[] expectedArray = new Integer[]{ 4, 6, 7, 8, 12, 15, 22, 84 };

        CocktailShakerSort<Integer> sortingAlgorithm = new CocktailShakerSort<>();
        sortingAlgorithm.shakerSort(inputArray);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void shouldRetrieveSortedArray_forFloatType() {
        Float[] inputArray = new Float[]{ 44.0F, 2.0F, 8.0F, 15.0F, 1.0F, 6.0F, 48.0F, 16.0F };
        Float[] expectedArray = new Float[]{ 1.0F, 2.0F, 6.0F, 8.0F, 15.0F, 16.0F, 44.0F, 48.0F };

        CocktailShakerSort<Float> sortingAlgorithm = new CocktailShakerSort<>();
        sortingAlgorithm.shakerSort(inputArray);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void shouldRetrieveSortedArray_forStringType() {
        String[] inputArray = new String[]{ "brother", "armchair", "mint", "suburb", "centre", "switching", "working", "wafer", "spiral" };
        String[] expectedArray = new String[]{ "armchair", "brother", "centre", "mint", "spiral", "suburb", "switching", "wafer", "working" };

        CocktailShakerSort<String> sortingAlgorithm = new CocktailShakerSort<>();
        sortingAlgorithm.shakerSort(inputArray);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }
}
