package ua.hillel.homeworks.homework32.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hillel.homeworks.homework32.model.entity.Order;
import ua.hillel.homeworks.homework32.model.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BasicOrderService implements OrderService{

    private final OrderRepository orderRepository;

    public BasicOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void add(Order order) {
        orderRepository.save(order);

    }

    @Override
    @Transactional
    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}
