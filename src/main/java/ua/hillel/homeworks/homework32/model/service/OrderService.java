package ua.hillel.homeworks.homework32.model.service;

import ua.hillel.homeworks.homework32.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findById(long id);

    List<Order> findAll();

    void add(Order order);

    void delete(long id);
}
