package ua.ithillel.homeworks.homework5;

import java.util.Random;
import java.util.Scanner;

public class StringApplication {
    public static void main(String[] args) {

        //2
        int countSymbol = findSymbolOccurrence("parallelepiped", 'l');

        //3
        int wordPosition = findWordPosition("Apple", "ple");
        System.out.println(wordPosition);

        //4
        String reverseString = stringReverse("Hello");
        System.out.println(reverseString);

        //5
        boolean isPalindrome = checkIsPalindrome("ggdfdgg");
        System.out.println("Is this string palindrome? " + isPalindrome);

        //6*
        runGame();
    }

    static int findSymbolOccurrence(String someString, char someChar) {
        int count = 0;
        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == someChar) {
                count++;
            }
        }

        String stringInfo = String.format("The symbol '%c' is used %d times in the string '%s'", someChar, count, someString);
        System.out.println(stringInfo);

        return count;
    }

    static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    static String stringReverse(String someString) {
        return new StringBuilder(someString).reverse().toString();
    }

    static String stringReverseWithoutClass(String someString) {
        int length = someString.length();
        char[] charArrays = someString.toCharArray();
        char[] charArraysReverse = new char[length];

        for (int j = 0; j < length; j++) {
            charArraysReverse[j] = charArrays[length - j - 1];
        }
        return String.valueOf(charArraysReverse);
    }

    static boolean checkIsPalindrome(String someString) {
        return someString.equals(stringReverse(someString));
    }

    static boolean checkIsPalindromeWithoutClass(String someString) {
        int length = someString.length();

        for (int i = 0; i < length / 2; i++) {
            if (someString.charAt(i) != someString.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static void runGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        int wordCount = random.nextInt(words.length);
        String hiddenWord = words[wordCount];

        System.out.println("Hello, friend! Welcome to the Game!");
        System.out.println("You have to guess a word.");

        while (true) {
            char[] result = "###############".toCharArray();
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String variant = scanner.nextLine();

            int wordLength = Math.min(hiddenWord.length(), variant.length());
            for (int i = 0; i < wordLength; i++) {
                if (hiddenWord.charAt(i) == variant.charAt(i)) {
                    result[i] = variant.charAt(i);
                }
            }
            if (hiddenWord.compareTo(variant) == 0) {
                System.out.println("You win! The End.");
                scanner.close();
                break;
            }

            System.out.println(result);
        }
    }
}

