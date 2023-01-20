package ua.hillel.homeworks.homework33.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.hillel.homeworks.homework33.model.entity.Order;
import ua.hillel.homeworks.homework33.model.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderRepository.getOrders();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable(value = "id") long id) {
        Optional<Order> order = orderRepository.getById(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order.get());
    }
}
