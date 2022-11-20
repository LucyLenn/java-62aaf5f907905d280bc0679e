package ua.hillel.homeworks.homework23;

public class CocktailShakerSort<T extends Comparable<T>> {

    public void shakerSort(T[] array) {

        if (array == null || array.length == 0) {
            throw new RuntimeException("Array must not be null or empty.");
        }

        T temp;
        int minIndex = 0;
        int maxIndex = array.length - 1;

        do {
            for (int i = minIndex; i < maxIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            maxIndex--;

            for (int i = maxIndex; i > minIndex; i--) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            minIndex++;

        } while (minIndex < maxIndex);
    }
}
