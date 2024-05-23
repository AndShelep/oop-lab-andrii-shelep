package org.example.springshop.services;

import org.example.springshop.Client;
import org.example.springshop.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> getOrders();
    public Order getOrder(String id);
    public String createOrder(Client client);
    public void cancelOrder(String id);
    public List<Order> clientsOrders(String clientId);
}
