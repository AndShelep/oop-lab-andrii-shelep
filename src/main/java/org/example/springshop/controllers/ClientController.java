package org.example.springshop.controllers;

import org.example.springshop.Client;
import org.example.springshop.Device;
import org.example.springshop.services.ClientService;
import org.example.springshop.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;
    private DeviceService deviceService;

    @Autowired
    public ClientController(ClientService clientService, DeviceService deviceService) {
        this.clientService = clientService;
        this.deviceService = deviceService;
    }

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAllClients();
    }

    @GetMapping("/get/{clientId}")
    public Client get(@PathVariable String clientId) {
        return clientService.getClient(clientId);
    }

    @PostMapping("/add")
    public void add(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @DeleteMapping("/remove/{clientId}")
    public void remove(@PathVariable String clientId) {
        clientService.deleteClient(clientId);
    }

    @PostMapping("{clientId}/add_to_cart/{model}")
    public void addToCart(@PathVariable String clientId, @PathVariable String model) {
        Device device = deviceService.getDevice(model);
        clientService.addToCart(device, clientId);
    }

    @DeleteMapping("{clientId}/remove_from_cart/{model}")
    public void removeFromCart(@PathVariable String clientId, @PathVariable String model) {
        Device device = deviceService.getDevice(model);
        clientService.removeFromCart(device, clientId);
    }

    @GetMapping("/{clientId}/cart")
    public List<Device> getCart(@PathVariable String clientId) {
        return clientService.getCart(clientId);
    }
}
