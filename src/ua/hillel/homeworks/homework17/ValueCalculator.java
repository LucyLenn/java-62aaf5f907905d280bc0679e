package ua.hillel.homeworks.homework17;

import java.util.Arrays;

public class ValueCalculator {
    private static final int SIZE = 1_000_000;
    private static final int HALF_SIZE = SIZE / 2;
    private float[] array = new float[SIZE];

    public void doCalc() {
        long start = System.currentTimeMillis();

        Arrays.fill(array, 7);

        float[] array1 = new float[HALF_SIZE];
        float[] array2 = new float[HALF_SIZE];

        System.arraycopy(array, 0, array1, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, array2, 0, HALF_SIZE);

        Thread thread1 = new Thread(() -> assignNewValues(array1));
        Thread thread2 = new Thread(() -> assignNewValues(array2));

        thread1.start();
        thread2.start();

        joinThread(thread1);
        joinThread(thread2);

        System.arraycopy(array1, 0, array, 0, HALF_SIZE);
        System.arraycopy(array2, 0, array, HALF_SIZE, HALF_SIZE);

        System.out.println("Operation time: " + (System.currentTimeMillis() - start));
    }

    private void assignNewValues(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException("Some mistake in 'join' method of the thread", ex);
        }
    }
}
