package ua.hillel.homeworks.homework6;

public class Dog extends Animal {
    private static int countDog;
    private final int MAX_RUN = 500;
    private final int MAX_SWIM = 10;

    public Dog(String name) {
        super(name);
        countDog++;
   }
    public static int getCountDog() {
        return countDog;
    }

    public void swim(int distance) {
        if (distance > MAX_SWIM) {
            System.out.println("Dog " + getName() + " can't swim more than " + MAX_SWIM + " m.");
            return;
        }
        System.out.println("Dog " + getName() + " swam " + distance + " m.");
    }

    public void run(int distance) {
        if (distance > MAX_RUN) {
            System.out.println("Dog " + getName() + " can't run more than " + MAX_RUN + " m.");
            return;
        }
        System.out.println("Dog " + getName() + " ran " + distance + " m.");
    }
}