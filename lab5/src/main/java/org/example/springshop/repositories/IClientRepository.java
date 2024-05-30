package org.example.springshop.repositories;

import org.example.springshop.Client;
import org.example.springshop.Device;

import java.util.List;

public interface IClientRepository {
    List<Client> getClients();
    Client getClient(String clientId);
    Client addClient(Client client);
    String removeClient(Client client);
    String addToCart(Device device, Client client);
    String removeFromCart(Device device, Client client);
    public List<Device> getCart(String clientId);
}
