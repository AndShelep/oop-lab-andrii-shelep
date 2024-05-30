package org.example.springshop.repositories;

import org.example.springshop.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrder(String id) {
        for (Order order : orders) {
            if (order.getOrderId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public String addOrder(Order order) {
        orders.add(order);
        return "Order created";
    }

    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    public List<Order> clientsOrders(String clientId) {
        List<Order> clientsOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getClient().getId().equals(clientId)) {
                clientsOrders.add(order);
            }
        }
        return clientsOrders;
    }
}
