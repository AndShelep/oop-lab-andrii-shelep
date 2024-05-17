package org.example.springshop.services;

import java.util.List;
import org.example.springshop.Client;
import org.example.springshop.Device;

public interface IClientService {
    public List<Client> getAllClients();
    public Client getClient(String clientId);
    public void addClient(Client client);
    public void deleteClient(String clientId);
    public void addToCart(Device device, String clientId);
    public void removeFromCart(Device device, String clientId);
    public List<Device> getCart(String clientId);
}
