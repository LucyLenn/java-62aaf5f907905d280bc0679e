package ua.hillel.homeworks.homework;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        System.out.println(isStringNonEmpty(""));
        System.out.println(isStringNonEmpty("testString"));

        System.out.println(checkStringLetters("Nevada"));
        System.out.println(checkStringLetters("JAVA"));

        handleCargoBox(new CargoBox(550));

        System.out.println("Discriminant = " + calculateDiscriminant(20.05, 30, 10.56));

        System.out.println("Random number between 0 and 10 (inclusive): " + getRandomNumber());
    }

    static boolean isStringNonEmpty(String checkString) {
        Predicate<String> stringPredicate = s -> !s.isEmpty();
        return stringPredicate.test(checkString);
    }

    static boolean checkStringLetters(String checkString) {
        Predicate<String> stringPredicate = s -> (s.startsWith("J") || s.startsWith("N")) && s.endsWith("A");
        return stringPredicate.test(checkString);
    }

    static void handleCargoBox(CargoBox cargoBox) {
        Consumer<CargoBox> shipmentBox = box -> System.out.println("Shipped the box, weight: " + box.weight());
        Consumer<CargoBox> dispatchBox = box -> System.out.println("Dispatch the box, weight: " + box.weight());
        shipmentBox.andThen(dispatchBox).accept(cargoBox);
    }

    static double calculateDiscriminant(double a, double b, double c) {
        Double[] variables = { a, b, c };
        Function<Double[], Double> discriminant = (v) -> (Math.pow(v[1], 2)) - (4 * v[0] * v[2]);
        return discriminant.apply(variables);
    }

    static int getRandomNumber() {
        Supplier<Integer> number = () -> new Random().nextInt(11);
        return number.get();
    }
}

