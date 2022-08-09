package ua.ithillel.homeworks.homework4;

public class HomeWorkApp {

    public static void main(String[] args) {
        //2
        printThreeWords();

        //3
        checkSumSign();

        //4
        printColor();

        //5
        compareNumbers();

        //6
        System.out.println("The sum of 2 and 11 is in the period between 10 and 20: " + calculateSumPeriod(2, 11));     // true
        System.out.println("The sum of 35 and 11 is in the period between 10 and 20: " + calculateSumPeriod(35, 11));   // false

        //7
        checkSignNumber(-99);

        //8
        System.out.println("-55 is negative number: " + returnSignNumber(-55));     // true
        System.out.println("55 is negative number: " + returnSignNumber(55));       // false

        //9
        printStringNtimes("Aloha", 4);

        //10*
        System.out.println("1700 is the leap year: " + determineLeapYear(1700));    // false
        System.out.println("1600 is the leap year: " + determineLeapYear(1600));    // true
        System.out.println("2100 is the leap year: " + determineLeapYear(2100));    // false
        System.out.println("2016 is the leap year: " + determineLeapYear(2016));    // true
    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        int a = 11;
        int b = 5;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Positive amount");
        } else {
            System.out.println("Negative amount");
        }
    }

    static void printColor() {
        int value = 123;

        if (value <= 0) {
            System.out.println("Red");
        } else if (value > 0 && value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    static void compareNumbers() {
        int a = 22;
        int b = 33;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static boolean calculateSumPeriod(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    static void checkSignNumber(int a) {
        if (a >= 0) {
            System.out.println("Positive number");
        } else {
            System.out.println("Negative number");
        }
    }

    static boolean returnSignNumber(int a) {
        return a < 0;
    }

    static void printStringNtimes(String word, int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(i + ". " + word);
        }
    }

    static boolean determineLeapYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

}
