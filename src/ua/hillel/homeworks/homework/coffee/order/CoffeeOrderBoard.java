package ua.hillel.homeworks.homework.coffee.order;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class CoffeeOrderBoard {
    private final Deque<Order> orders = new ArrayDeque<>();
    private int currentOrderNumber = 1;

    public void add(String name) {
        orders.offerLast(new Order(currentOrderNumber++, name));
    }

    public Optional<Order> deliver() {
        return Optional.ofNullable(orders.pollFirst());
    }

    public Optional<Order> deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public void draw() {
        System.out.println("====================");
        System.out.println("Num\t\t|\t\tName");
        orders.forEach(System.out::println);
    }
}
