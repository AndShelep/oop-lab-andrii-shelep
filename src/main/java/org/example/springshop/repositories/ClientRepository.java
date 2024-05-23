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
        clients.add(new Client("12345","Andrew", "Shelep", "+380000000000", "shelepovskiy@gmail.com"));
        clients.add(new Client("12346","Andrii", "Vilkosh", "+380000002310", "vylka@gmail.com"));
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client addClient(Client client) {
        this.clients.add(client);
        return client;
    }

    public String removeClient(Client client) {
        this.clients.remove(client);
        return "Client removed";
    }

    public Client getClient(String clientId) {
        for (Client client : this.clients) {
            if (client.getId().equals(clientId))
                return client;
        }
        return null;
    }

    public String addToCart(Device device, Client client){
        client.addToCart(device);
        return "Device added to cart";
    }

    public String removeFromCart(Device device, Client client){
        client.removeFromCart(device);
        return "Device removed from cart";
    }

    public List<Device> getCart(String clientId){
        Client client = getClient(clientId);
        if(client != null){
            return client.showCart();
        }
        return null;
    }
}
