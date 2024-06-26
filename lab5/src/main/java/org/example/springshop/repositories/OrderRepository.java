package org.example.springshop.repositories;

import org.example.springshop.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository implements IORderRepository {
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public Order getOrder(String id) {
        for (Order order : orders) {
            if (order.getOrderId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public String addOrder(Order order) {
        orders.add(order);
        return "Order created";
    }

    @Override
    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    @Override
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
