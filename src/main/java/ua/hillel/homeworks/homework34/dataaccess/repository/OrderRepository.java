package ua.hillel.homeworks.homework34.dataaccess.repository;

import ua.hillel.homeworks.homework34.dataaccess.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> getById(long id);

    List<Order> getOrders();

    void add(Order order);
}
