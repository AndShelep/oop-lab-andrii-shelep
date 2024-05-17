package org.example.springshop.services;

import org.example.springshop.Client;
import org.example.springshop.Device;
import org.example.springshop.repositories.ClientRepository;
import org.example.springshop.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private ClientRepository clientRepository;
    //private DeviceRepository deviceRepository;

    public ClientService(ClientRepository clientRepository/*, DeviceRepository deviceRepository*/) {
        this.clientRepository = clientRepository;
        //this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getClients();
    }

    @Override
    public Client getClient(String clientId) {
        return clientRepository.getClient(clientId);
    }

    @Override
    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    @Override
    public void deleteClient(String clientId) {
        Client client = clientRepository.getClient(clientId);
        if(client != null) {
            clientRepository.removeClient(client);
        }
    }

    @Override
    public void addToCart(Device device, String clientId) {
        Client client = clientRepository.getClient(clientId);
        if(device != null && client != null) {
            clientRepository.addToCart(device, client);
        }
    }

    @Override
    public void removeFromCart(Device device, String clientId) {
        Client client = clientRepository.getClient(clientId);
        if(client != null) {
            if(device != null && client.isInCart(device)) {
                clientRepository.removeFromCart(device, client);
            }
        }
    }

    @Override
    public List<Device> getCart(String clientId) {
        return clientRepository.getCart(clientId);
    }
}
