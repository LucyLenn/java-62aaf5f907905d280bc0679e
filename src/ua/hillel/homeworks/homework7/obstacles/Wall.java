package ua.hillel.homeworks.homework7.obstacles;

public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean overcome(Participant participant) {
        int limitJump = participant.getLimitJump();

        participant.jump();
        if (limitJump < height) {
            System.out.printf("%s can't pass the wall on distance %d. Passed %d.\n", participant.getName(), height, limitJump);
            return false;
        } else {
            System.out.printf("%s passes the wall on distance %d.\n", participant.getName(), height);
            return true;
        }
    }
}
