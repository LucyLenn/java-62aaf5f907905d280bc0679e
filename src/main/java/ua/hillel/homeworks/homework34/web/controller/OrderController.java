package ua.hillel.homeworks.homework34.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.hillel.homeworks.homework34.dataaccess.entity.Order;
import ua.hillel.homeworks.homework34.dataaccess.repository.BasicOrderRepository;

import java.util.Optional;

@Controller
public class OrderController {
    private final BasicOrderRepository orderRepository;

    public OrderController(BasicOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value = "/orders")
    public String getOrders(Model uiModel) {
        uiModel.addAttribute("orders", orderRepository.getOrders());
        return "orders";
    }

    @GetMapping(value = "/order-{id}")
    public String showById(Model uiModel, @PathVariable(value = "id") int id) {
        Optional<Order> order = orderRepository.getById(id);
        order.ifPresent(value -> uiModel.addAttribute("order", value));
        return "order";
    }
}
