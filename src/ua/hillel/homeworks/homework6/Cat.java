package ua.hillel.homeworks.homework6;

public class Cat extends Animal {
    private static int countCat;
    private static final int MAX_RUN = 200;

    public Cat(String name) {
        super(name);
        countCat++;
    }

    public static int getCountCat() {
        return countCat;
    }

    public void swim(int distance) {
        System.out.println("Cats can't swim!");
    }

    public void run(int distance) {
        if (distance > MAX_RUN) {
            System.out.println("Cat " + getName() + " can't run more than " + MAX_RUN + " m.");
            return;
        }
        System.out.println("Cat " + getName() + " ran " + distance + " m.");
    }
}
