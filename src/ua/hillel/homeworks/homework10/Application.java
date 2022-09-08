package ua.hillel.homeworks.homework10;

public class Application {
    public static void main(String[] args) {
        String[][] array = {
                { "1", "1", "1", "1" },
                { "2", "2", "2", "2" },
                { "3", "3", "3", "3" },
                { "4", "4", "4", "4" }
        };
        ArrayValueCalculator arrayCalculator = new ArrayValueCalculator();

        try {
            System.out.println("The sum of elements in array: " + arrayCalculator.doCalc(array));
        } catch (ArraySizeException | ArrayDataException ex) {
            System.err.println("The sum hasn't been calculated. Check array: " + ex.getMessage());
        }
    }
}
