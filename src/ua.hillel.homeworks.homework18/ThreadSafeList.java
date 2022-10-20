package ua.hillel.homeworks.homework18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<E> {
    private final List<E> list = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(E element) {
        try {
            lock.writeLock().lock();
            list.add(element);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void remove(int index) {
        try {
            lock.writeLock().lock();
            list.remove(index);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public E get(int index) {
        try {
            lock.readLock().lock();
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }
}
