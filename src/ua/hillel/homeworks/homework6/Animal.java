package ua.hillel.homeworks.homework6;

public abstract class Animal {
    private static int countAnimal;
    private String name;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    public abstract void swim(int distance);

    public abstract void run(int distance);

    public static int getCountAnimal() {
        return countAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


