package ua.hillel.homeworks.homework11;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruitsBox = new ArrayList<>();

    public void addFruit(T fruit) {
        fruitsBox.add(fruit);
    }

    public void addFruits(T... fruits) {
        fruitsBox.addAll(List.of(fruits));
    }

    public float getWeight() {
        return fruitsBox.isEmpty() ? 0F : fruitsBox.get(0).getWeight() * fruitsBox.size();
    }

    public boolean compare(Box<? extends Fruit> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    public void merge(Box<T> otherBox) {
        fruitsBox.addAll(otherBox.fruitsBox);
        otherBox.fruitsBox.clear();
    }
}
