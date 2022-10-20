package ua.hillel.homeworks.homework18;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PetrolStation {
    private final Semaphore semaphore = new Semaphore(3);
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private float totalFuelAmount;
    private float restReservedFuelAmount;
    private boolean isEndFuel;

    public PetrolStation(float totalFuelAmount) {
        this.totalFuelAmount = totalFuelAmount;
        this.restReservedFuelAmount = totalFuelAmount;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public float getTotalFuelAmount() {
        try {
            lock.readLock().lock();
            return totalFuelAmount;
        } finally {
            lock.readLock().unlock();
        }
    }

    public float getRestReserveFuelAmount() {
        try {
            lock.readLock().lock();
            return restReservedFuelAmount;
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean isEndFuel() {
        return isEndFuel;
    }

    public void doRefuel(float amountRefuel) {
        String nameThread = Thread.currentThread().getName();

        try {
            semaphore.acquire();

            if (getRestReserveFuelAmount() <= 0) {
                System.out.println("Oops, not will enough fuel...: " + nameThread);
                return;
            }

            System.out.printf("Refueling in progress on %f...: %s%n", amountRefuel, nameThread);
            calcRestReservedFuel(amountRefuel);
            toSleep(3_000, 10_000);
            calcFuelAmount(amountRefuel);
        } catch (InterruptedException ex) {
            throw new RuntimeException(
                    String.format("Error. Current thread %s is interrupted in refueling at amount: %s",
                            nameThread, amountRefuel), ex);
        } finally {
            System.out.println(nameThread + " gone.");
            semaphore.release();
        }
    }

    private void calcFuelAmount(float amountRefuel) {
        try {
            lock.writeLock().lock();

            float beforeTotalFuelAmount = totalFuelAmount;
            if (totalFuelAmount - amountRefuel > 0) {
                totalFuelAmount -= amountRefuel;
            } else {
                totalFuelAmount = 0;
                isEndFuel = true;
            }
            System.out.printf(
                    "Then total fuel: %f, refuel: %f, now: %f%n", beforeTotalFuelAmount, amountRefuel, totalFuelAmount);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void calcRestReservedFuel(float amountRefuel) {
        try {
            lock.writeLock().lock();
            restReservedFuelAmount =
                    (restReservedFuelAmount - amountRefuel > 0) ? (restReservedFuelAmount - amountRefuel) : 0;
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void toSleep(int a, int b) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(a, b));
        } catch (InterruptedException ex) {
            throw new RuntimeException(
                    "Current thread is interrupted in sleep:" + Thread.currentThread().getName(), ex);
        }
    }
}
