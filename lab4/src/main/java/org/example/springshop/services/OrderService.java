package org.example.springshop.services;

import org.example.springshop.Client;
import org.example.springshop.Device;
import org.example.springshop.Order;
import org.example.springshop.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public Order getOrder(String id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public String createOrder(Client client) {
        List<Device> devices = client.showCart();
        if (!devices.isEmpty()) {
            Order order = new Order(devices, client);
            return orderRepository.addOrder(order);
        }
        return "There are no devices in carts";
    }

    @Override
    public void cancelOrder(String id) {
        Order order = orderRepository.getOrder(id);
        if (order != null) {
            orderRepository.cancelOrder(order);
        }
    }

    @Override
    public List<Order> clientsOrders(String clientId) {
        return orderRepository.clientsOrders(clientId);
    }
}
