package ua.hillel.homeworks.homework7.obstacles;

public class Treadmill implements Obstacle {
    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean overcome(Participant participant) {
        int limitRun = participant.getLimitRun();

        participant.run();
        if (limitRun < length) {
            System.out.printf("%s can't pass the treadmill on distance %d. Passed %d.\n", participant.getName(), length, limitRun);
            return false;
        } else {
            System.out.printf("%s passes the treadmill on distance %d.\n", participant.getName(), length);
            return true;
        }

    }
}
