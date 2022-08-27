package ua.hillel.homeworks.homework7.obstacles;

public class Human extends Participant {
    public Human(String name, int limitJump, int limitRun) {
        super(name, limitJump, limitRun);
    }

    @Override
    public void jump() {
        System.out.println(getName() + " jump!");
    }

    @Override
    public void run() {
        System.out.println(getName() + " run!");
    }
}
