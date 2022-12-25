package ua.hillel.homeworks.homework28;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        Cart cart = ctx.getBean(Cart.class);

        System.out.println("Welcome! Please follow the instructions!");
        printInstructions();

        while (true) {
            System.out.println("Press:");
            switch (scanner.nextInt()) {
                case 0 -> printInstructions();
                case 1 -> cart.printProductCart();
                case 2 -> add(cart);
                case 3 -> remove(cart);
                case 4 -> {
                    exit();
                    return;
                }
                default -> System.out.println("Unexpected value. Please, try again.");
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\t 0 - print choice options.");
        System.out.println("\t 1 - print the list of products in your cart.");
        System.out.println("\t 2 - add a product to the cart from product repository.");
        System.out.println("\t 3 - remove a product from the cart.");
        System.out.println("\t 4 - quit.");
    }

    private static void add(Cart cart) {
        System.out.println("Input id of product:");
        int id = scanner.nextInt();
        if (scanner.hasNextInt()) {
            cart.addById(id);
        }
    }

    private static void remove(Cart cart) {
        System.out.println("Input id of product:");
        int id = scanner.nextInt();
        if (scanner.hasNextInt()) {
            cart.removeById(id);
        }
    }

    private static void exit() {
        System.out.println("Thank you for using our services.");
        scanner.close();
    }
}
