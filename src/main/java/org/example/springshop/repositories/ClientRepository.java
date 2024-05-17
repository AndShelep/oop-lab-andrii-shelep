package org.example.springshop.repositories;

import org.example.springshop.Client;
import org.example.springshop.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public ClientRepository() {
        clients.add(new Client("Andrew", "Shelep", "+380000000000", "shelepovskiy@gmail.com"));
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    public Client getClient(String clientId) {
        for (Client client : this.clients) {
            if (client.getId().equals(clientId))
                return client;
        }
        return null;
    }

    public void addToCart(Device device, Client client){
        client.addToCart(device);
    }

    public void removeFromCart(Device device, Client client){
        client.removeFromCart(device);
    }

    public List<Device> getCart(String clientId){
        Client client = getClient(clientId);
        if(client != null){
            return client.showCart();
        }
        return null;
    }
}
