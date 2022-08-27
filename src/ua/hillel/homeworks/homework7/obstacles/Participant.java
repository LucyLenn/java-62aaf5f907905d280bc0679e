package ua.hillel.homeworks.homework7.obstacles;

public abstract class Participant {
    private final int limitJump;
    private final int limitRun;
    private String name;

    public Participant(String name, int limitJump, int limitRun) {
        this.name = name;
        this.limitJump = limitJump;
        this.limitRun = limitRun;
     }

    public int getLimitJump() {
        return limitJump;
    }

    public int getLimitRun() {
        return limitRun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void jump();

    public abstract void run();
}
