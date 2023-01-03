package ua.hillel.homeworks.homework30.component;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order {
    private long id;
    private LocalDateTime date;
    private long cost;
    private final List<Product> products;

    public Order(long id, LocalDateTime date, long cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }
}
