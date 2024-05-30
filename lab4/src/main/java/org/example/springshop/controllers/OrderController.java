package org.example.springshop.controllers;

import org.example.springshop.Client;
import org.example.springshop.services.ClientService;
import org.example.springshop.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.example.springshop.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private ClientService clientService;

    public OrderController(OrderService orderService, ClientService clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/clients_orders/{clientId}")
    public List<Order> getClientOrders(@PathVariable String clientId) {
        return orderService.clientsOrders(clientId);
    }

    @GetMapping("/get/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/create/{clientId}")
    public String createOrder(@PathVariable String clientId) {
        Client client = clientService.getClient(clientId);
        if(client != null) {
            return orderService.createOrder(client);
        }
        return "Error: Client not found";
    }

    @DeleteMapping("/cancel/{id}")
    public void removeOrder(@PathVariable String id) {
        orderService.cancelOrder(id);
    }
}
