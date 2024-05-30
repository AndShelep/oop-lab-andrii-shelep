package org.example.springshop.services;

import java.util.List;
import org.example.springshop.Client;
import org.example.springshop.Device;

public interface IClientService {
    public List<Client> getAllClients();
    public Client getClient(String clientId);
    public Client addClient(Client client);
    public String deleteClient(String clientId);
    public String addToCart(Device device, String clientId);
    public String removeFromCart(Device device, String clientId);
    public List<Device> getCart(String clientId);
}
