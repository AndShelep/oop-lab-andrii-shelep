package org.example.springshop.repositories;

import org.example.springshop.Order;

import java.util.List;

public interface IORderRepository {
    public Order getOrder(String id);
    public String addOrder(Order order);
    public void cancelOrder(Order order);
    List<Order> clientsOrders(String clientId);
}
