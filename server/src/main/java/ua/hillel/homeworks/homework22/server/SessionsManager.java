package ua.hillel.homeworks.homework22.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SessionsManager {
    private static final Logger log = LogManager.getLogger(SessionsManager.class);
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<ClientSession> activeClients = new ArrayList<>();

    public List<ClientSession> getActiveClients() {
        return activeClients;
    }

    public void addSession(ClientSession session) {
        try {
            lock.writeLock().lock();
            activeClients.add(session);
            log.info("{} added to active clients list", session.getClientName());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void removeSession(ClientSession session) {
        try {
            lock.readLock().lock();
            activeClients.remove(session);
            log.info("{} removed from active clients list", session.getClientName());
        } finally {
            lock.readLock().unlock();
        }
    }

    public void sendMessageToAll(String message) {
        for (ClientSession client : activeClients) {
            client.sendMessage(message);
        }
    }

}
