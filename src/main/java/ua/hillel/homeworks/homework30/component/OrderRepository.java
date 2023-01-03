package ua.hillel.homeworks.homework30.component;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }

    @PostConstruct
    public void fillProductRepository() {
        orders.add(
                new Order(1, LocalDateTime.now(), 100, List.of(
                        new Product(1, "name1", 10))));
        orders.add(
                new Order(2, LocalDateTime.now(), 150, List.of(
                        new Product(2, "name2", 50),
                        new Product(3, "name3", 50))));
        orders.add(
                new Order(3, LocalDateTime.now(), 90, List.of(
                        new Product(4, "name4", 40),
                        new Product(5, "name5", 50))));
        orders.add(
                new Order(4, LocalDateTime.now(), 125, List.of(
                        new Product(1, "name6", 10))));
    }

    public Optional<Order> getById(int id) {
        return orders.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void add(Order order) {
        orders.add(order);
    }
}
