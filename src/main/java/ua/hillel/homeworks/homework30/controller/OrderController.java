package ua.hillel.homeworks.homework30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.hillel.homeworks.homework30.component.Order;
import ua.hillel.homeworks.homework30.component.OrderRepository;

import java.util.Optional;

@Controller
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value = "/orders")
    public String getOrders(Model uiModel) {
        uiModel.addAttribute("orderRepository", orderRepository.getOrders());
        return "orders";
    }

    @GetMapping(value = "/order-{id}")
    public String showById(Model uiModel, @PathVariable(value = "id") int id) {
        Optional<Order> order = orderRepository.getById(id);
        order.ifPresent(value -> uiModel.addAttribute("order", value));

        return "order";
    }
}
