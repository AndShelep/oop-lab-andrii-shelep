package org.example.springshop.services;

import org.example.springshop.Client;
import org.example.springshop.Device;
import org.example.springshop.repositories.ClientRepository;
import org.example.springshop.repositories.DeviceRepository;
import org.example.springshop.repositories.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private IClientRepository clientRepository = ClientRepository.getInstance();
    //private DeviceRepository deviceRepository;

    //public ClientService(ClientRepository clientRepository/*, DeviceRepository deviceRepository*/) {
    //    this.clientRepository = clientRepository;
        //this.deviceRepository = deviceRepository;
    //}

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getClients();
    }

    @Override
    public Client getClient(String clientId) {
        return clientRepository.getClient(clientId);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.addClient(client);
    }

    @Override
    public String deleteClient(String clientId) {
        Client client = clientRepository.getClient(clientId);
        if(clientRepository.getClient(clientId) != null) {
            return clientRepository.removeClient(client);
        } else {
            return "Client not found";
        }
    }

    @Override
    public String addToCart(Device device, String clientId) {
        Client client = clientRepository.getClient(clientId);
        if(device != null && client != null) {
            return clientRepository.addToCart(device, client);
        } else if (device == null && client != null) {
            return "Device not found";
        } else if (client == null && device != null) {
            return "Client not found";
        }
        return "Device not added to cart";
    }

    @Override
    public String removeFromCart(Device device, String clientId) {
        Client client = clientRepository.getClient(clientId);
        if(client != null) {
            if(device != null && client.isInCart(device)) {
                return clientRepository.removeFromCart(device, client);
            } else if (device == null) {
                return "Device not found";
            } else {
                return "Device is not in cart";
            }
        } else {
            return "Client not found";
        }
    }

    @Override
    public List<Device> getCart(String clientId) {
        return clientRepository.getCart(clientId);
    }
}
