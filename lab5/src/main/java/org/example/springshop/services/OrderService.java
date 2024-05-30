package org.example.springshop.services;

import org.example.springshop.*;
import org.example.springshop.repositories.DeviceRepository;
import org.example.springshop.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;
    private DeviceModelAdapter deviceModelAdapter = new DeviceModelAdapter();

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
            float cashback = 0.0f;
            List<DeviceModel> deviceModels = new ArrayList<>();
            for (Device device : devices) {
                cashback += device.getCashback();
                deviceModels.add(deviceModelAdapter.toDeviceModel(device));
            }
            Order order = new Order(deviceModels, cashback, client);
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
