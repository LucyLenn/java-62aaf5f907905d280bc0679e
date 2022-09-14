package ua.hillel.homeworks.homework;

import ua.hillel.homeworks.homework.coffee.order.CoffeeOrderBoard;

public class Application {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Flash");
        board.add("Batman");
        board.add("Superman");
        board.add("Wonder woman");
        board.draw();

        board.deliver().ifPresent((s) -> System.out.printf("%s, your order %d is ready.\n", s.getName(), s.getOrderNumber()));
        board.draw();

        board.add("Aquaman");
        board.draw();

        board.deliver(4).ifPresent((s) -> System.out.printf("%s, your order %d is ready.\n", s.getName(), s.getOrderNumber()));
        board.draw();
    }
}
