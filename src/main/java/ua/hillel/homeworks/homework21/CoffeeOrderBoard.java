package ua.hillel.homeworks.homework21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class CoffeeOrderBoard {

    private static final Logger log = LogManager.getLogger(CoffeeOrderBoard.class);

    private final Deque<Order> orders = new ArrayDeque<>();
    private int currentOrderNumber = 1;

    public void add(String name) {
        try {
            orders.offerLast(new Order(currentOrderNumber++, name));
            log.info("Order added, name: {}, order: {}", name, currentOrderNumber);
        } catch (ClassCastException | NullPointerException | IllegalArgumentException e) {
            log.error("Error in adding new order, name: {}, order: {}", name, currentOrderNumber, e);
        }
    }

    public Optional<Order> deliver() {
        var resultOrder = orders.pollFirst();
        if (resultOrder == null) {
            log.info("The table is empty, no orders to delete");
        }
        return Optional.ofNullable(resultOrder);
        // return Optional.ofNullable(orders.pollFirst()); // before logging...
    }

    public Optional<Order> deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.orderNumber() == orderNumber) {
                try {
                    orders.remove(order);
                } catch (ClassCastException | NullPointerException e) {
                    log.error("Error in removing order, name: {}, order: {}", order.name(), orderNumber, e);
                }
                return Optional.of(order);
            }
        }

        log.info("The order number {} is not find, removal is not possible", orderNumber);
        return Optional.empty();
    }

    public void draw() {
        System.out.println("====================");
        System.out.println("Num\t\t|\t\tName");
        orders.forEach(System.out::println);

        log.info("The list of orders is displayed successfully, size {}", orders.size());
    }
}
