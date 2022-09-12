package ua.hillel.homeworks.homework11;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] stringArray = { "piu", "paf" };
        Integer[] intArray = { 1, 2, 3 };

        System.out.println(toList(stringArray));
        System.out.println(toList(intArray));

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox1.addFruit(new Apple());
        appleBox2.addFruits(new Apple(), new Apple());
        orangeBox.addFruits(new Orange(), new Orange());

        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox1.compare(orangeBox));
        appleBox1.merge(appleBox2);
    }

    public static <T> List<T> toList(T[] array) {
        return List.of(array);
    }
}
