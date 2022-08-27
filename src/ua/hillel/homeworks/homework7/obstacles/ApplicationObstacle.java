package ua.hillel.homeworks.homework7.obstacles;

public class ApplicationObstacle {
    public static void main(String[] args) {
        Participant[] participants = getParticipants();
        Obstacle[] obstacles = getObstacles();

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    System.out.println(participant.getName() + " is out.");
                    break;
                }
            }
        }
    }

    private static Participant[] getParticipants() {
        return new Participant[]{
                new Human("Jo", 2, 500),
                new Cat("Misa", 6, 1000),
                new Robot("Bibo", 12, 2000)};
    }

    private static Obstacle[] getObstacles() {
        return new Obstacle[]{
                new Treadmill(200),
                new Wall(1),
                new Treadmill(800),
                new Wall(8)
        };
    }
}
