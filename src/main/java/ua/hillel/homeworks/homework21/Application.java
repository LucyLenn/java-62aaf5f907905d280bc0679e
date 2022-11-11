package ua.hillel.homeworks.homework21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        log.info("Application is star");
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        log.info("Add new order for name: Flash");
        board.add("Flash");

        log.info("Add new order for name: Batman");
        board.add("Batman");

        log.info("Add new order for name: Superman");
        board.add("Superman");

        log.info("Add new order for name: Wonder woman");
        board.add("Wonder woman");

        log.info("Display the list of orders on the board");
        board.draw();

        log.info("Delete closest order in line");
        board.deliver().ifPresent((s) -> {
                    System.out.printf("%s, your order %d is ready.\n", s.name(), s.orderNumber());
                    log.info("The closest order in line was successfully deleted, name: {}, order: {}", s.name(), s.orderNumber());
                }
        );

        log.info("Display the list of orders on the board");
        board.draw();

        log.info("Add new order for name: Aquaman");
        board.add("Aquaman");

        log.info("Display the list of orders on the board");
        board.draw();

        log.info("Delete order number 2");
        board.deliver(2).ifPresent((s) -> {
                    System.out.printf("%s, your order %d is ready.\n", s.name(), s.orderNumber());
                    log.info("The order was successfully deleted, name: {}, order: {}", s.name(), s.orderNumber());
                }
        );

        log.info("Display the list of orders on the board");
        board.draw();

        log.info("Application is end");
    }
}
