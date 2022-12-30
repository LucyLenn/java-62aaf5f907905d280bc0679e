package ua.hillel.homeworks.homework29.dataaccess.service;

import java.util.Optional;

public interface DaoService<T> {

    Optional<T> findById(long id);

    void add(T entity);

    void remove(long id);
}
