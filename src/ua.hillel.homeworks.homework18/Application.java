package ua.hillel.homeworks.homework18;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(1_000F);
        Random random = new Random();
        Semaphore semaphore = petrolStation.getSemaphore();

        for (int i = 0; i < 15; i++) {
            if (petrolStation.isEndFuel()) {
                System.out.println("No fuel. Station is closed: " + petrolStation.getTotalFuelAmount());
                return;
            }

            System.out.println("Available refueling posts: " + semaphore.availablePermits());
            System.out.println("Cars in line: " + semaphore.getQueueLength());

            Thread thread = new Thread(() -> petrolStation.doRefuel(random.nextFloat() * 500));
            thread.start();

            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(2000 - 1000 + 1) + 1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(
                        "Current thread is interrupted in sleep:" + thread.getName(), ex);
            }
        }
    }
}
