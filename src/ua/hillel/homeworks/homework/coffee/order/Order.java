package ua.hillel.homeworks.homework.coffee.order;

public class Order {
    private final int orderNumber;
    private final String name;

    public Order(int orderNumber, String name) {
        this.orderNumber = orderNumber;
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return orderNumber + "\t\t|\t\t" + name;
    }
}
