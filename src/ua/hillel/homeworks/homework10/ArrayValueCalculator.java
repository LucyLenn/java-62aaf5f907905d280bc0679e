package ua.hillel.homeworks.homework10;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) {
        checkSizeArray(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException(String.format("Invalid data format in [%s][%s] = \"%s\".", i, j, array[i][j]), ex);
                } catch (Exception ex) {
                    throw new RuntimeException("Caught an exception", ex);
                }
            }
        }
        return sum;
    }

    private void checkSizeArray(String[][] array) {
        if (array.length != 4) {
            throw new ArraySizeException(String.format("Rows must be 4, current value: %d.", array.length));
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new ArraySizeException(String.format("Columns must be 4. Row[%d] current value: %d.", i, array[i].length));
            }
        }
    }
}
