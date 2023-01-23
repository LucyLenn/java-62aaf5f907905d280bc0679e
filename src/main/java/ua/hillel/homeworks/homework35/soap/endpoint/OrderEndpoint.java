package ua.hillel.homeworks.homework35.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.hillel.homeworks.homework35.soap.repository.OrderRepository;
import ua.ithillel.soap.webservice.homework35.GetOrderByIdRequest;
import ua.ithillel.soap.webservice.homework35.GetOrderByIdResponse;
import ua.ithillel.soap.webservice.homework35.GetOrdersResponse;
import ua.ithillel.soap.webservice.homework35.Order;

import java.util.Optional;

@Endpoint
public class OrderEndpoint {

    private static final String NAMESPACE_URI = "http://ithillel.ua/soap-web-service/homework35";

    private OrderRepository orderRepository;

    public OrderEndpoint(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrdersRequest")
    @ResponsePayload
    public GetOrdersResponse getOrders() {
        GetOrdersResponse response = new GetOrdersResponse();
        response.getOrder().addAll(orderRepository.getOrders());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderByIdRequest")
    @ResponsePayload
    public GetOrderByIdResponse getOrderById(@RequestPayload GetOrderByIdRequest request) {
        GetOrderByIdResponse response = new GetOrderByIdResponse();
        Optional<Order> order = orderRepository.getOrderById(request.getId());

        order.ifPresent(response::setOrder);
        return response;
    }
}
