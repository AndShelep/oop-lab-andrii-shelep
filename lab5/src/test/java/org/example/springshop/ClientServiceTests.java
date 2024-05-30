package org.example.springshop;

import org.example.springshop.repositories.ClientRepository;
import org.example.springshop.repositories.DeviceRepository;
import org.example.springshop.services.ClientService;
import org.example.springshop.services.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertNull;

@SpringBootTest
public class ClientServiceTests {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private DeviceRepository deviceRepository;
    @InjectMocks
    private ClientService clientService;
    @InjectMocks
    private DeviceService deviceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddClient() {
        Client client = new Client("12347", "Sasha", "Zimnov", "+3809561294951", "sashenka@gmail.com");
        when(clientService.addClient(client)).thenReturn(client);

        Client result = clientService.addClient(client);

        assertEquals(client, result);
    }

    @Test
    public void testGetClientByIdSuccess() {
        Client client = new Client("12348","Sasha", "Sashenka", "+380654554951", "sashoka@gmail.com");
        clientService.addClient(client);
        when(clientService.getClient(client.getId())).thenReturn(client);

        Client result = clientService.getClient(client.getId());

        assertEquals(client, result);
    }

    @Test
    public void testGetClientByIdFailure() {
        when(clientService.getClient("234sd5f67")).thenReturn(null);

        Client result = clientService.getClient("234sd5f67");

        assertEquals(null, result);
    }

    @Test
    public void testRemoveClientSuccess() {
        Client client = new Client("12346","Andrii", "Vilkosh", "+380000002310", "vylka@gmail.com");
        when(clientService.getClient("12346")).thenReturn(client);
        when(clientService.deleteClient("12346")).thenReturn("Client removed");

        String result = clientService.deleteClient("12346");

        assertEquals("Client removed", result);
    }

    @Test
    public void testRemoveClientFailure() {
        when(clientService.getClient("13346")).thenReturn(null);

        String result = clientService.deleteClient("13346");

        assertEquals("Client not found", result);
    }

    @Test
    public void testAddToCartSuccess() {
        Device device = new Phone("apple iphone 11", 15000f, 8, 8, 3000, 24, 12);
        Client client = new Client("12346","Andrii", "Vilkosh", "+380000002310", "vylka@gmail.com");
        when(deviceService.getDevice("apple iphone 11")).thenReturn(device);
        when(clientService.getClient("12346")).thenReturn(client);
        when(clientService.addToCart(device, "12346")).thenReturn("Device added to cart");

        String result = clientService.addToCart(device, "12346");

        assertEquals("Device added to cart", result);
    }

    @Test
    public void testAddToCartFailureClientNotFound() {
        Device device = new Phone("apple iphone 11", 15000f, 8, 8, 3000, 24, 12);
        when(deviceService.getDevice("apple iphone 11")).thenReturn(device);
        when(clientService.getClient("12300")).thenReturn(null);

        String result = clientService.addToCart(device, "12300");

        assertEquals("Client not found", result);
    }

    @Test
    public void testAddToCartFailureDeviceNotFound() {
        Client client = new Client("12346","Andrii", "Vilkosh", "+380000002310", "vylka@gmail.com");
        Device device = null;
        when(deviceService.getDevice("apple iphone X")).thenReturn(device);
        when(clientService.getClient("12346")).thenReturn(client);

        String result = clientService.addToCart(device, "12346");

        assertEquals("Device not found", result);
    }

    @Test
    public void testAddToCartFailure() {
        Device device = null;
        Client client = null;
        when(deviceService.getDevice("apple iphone 11")).thenReturn(device);
        when(clientService.getClient("12300")).thenReturn(client);

        String result = clientService.addToCart(device, "12300");

        assertEquals("Device not added to cart", result);
    }

    @Test
    public void testRemoveFromCartSuccess() {
        Device device = new Phone("apple iphone 11", 15000f, 8, 8, 3000, 24, 12);
        Client client = mock(Client.class);
        when(client.getId()).thenReturn("12346");
        when(client.getName()).thenReturn("Andrii");
        when(client.getSurname()).thenReturn("Vilkosh");
        when(client.getNumber()).thenReturn("+380000002310");
        when(client.getEmail()).thenReturn("vylka@gmail.com");

        when(clientService.getClient("12346")).thenReturn(client);
        when(clientService.addToCart(device, "12346")).thenReturn("Device added to cart");
        when(client.isInCart(device)).thenReturn(true);
        when(clientService.removeFromCart(device, "12346")).thenReturn("Device removed from cart");

        String addToCartResult = clientService.addToCart(device, "12346");
        assertEquals("Device added to cart", addToCartResult);

        String removeFromCartResult = clientService.removeFromCart(device, "12346");
        assertEquals("Device removed from cart", removeFromCartResult);
    }

    @Test
    public void testRemoveFromCartFailureClientNotFound() {
        Device device = new Phone("apple iphone 11", 15000f, 8, 8, 3000, 24, 12);
        when(clientService.getClient("12300")).thenReturn(null);

        String removeFromCartResult = clientService.removeFromCart(device, "12300");

        assertEquals("Client not found", removeFromCartResult);
    }

    @Test
    public void testRemoveFromCartFailureDeviceNotFound() {
        Device device = null;
        Client client = mock(Client.class);
        when(client.getId()).thenReturn("12346");
        when(client.getName()).thenReturn("Andrii");
        when(client.getSurname()).thenReturn("Vilkosh");
        when(client.getNumber()).thenReturn("+380000002310");
        when(client.getEmail()).thenReturn("vylka@gmail.com");

        when(clientService.getClient("12346")).thenReturn(client);

        String result = clientService.removeFromCart(device, "12346");

        assertEquals("Device not found", result);
    }

    @Test
    public void testRemoveFromCartFailure() {
        Device device = new Phone("apple iphone 11", 15000f, 8, 8, 3000, 24, 12);
        Client client = mock(Client.class);
        when(client.getId()).thenReturn("12346");
        when(client.getName()).thenReturn("Andrii");
        when(client.getSurname()).thenReturn("Vilkosh");
        when(client.getNumber()).thenReturn("+380000002310");
        when(client.getEmail()).thenReturn("vylka@gmail.com");

        when(clientService.getClient("12346")).thenReturn(client);
        when(client.isInCart(device)).thenReturn(false);

        String result = clientService.removeFromCart(device, "12346");
        
        assertEquals("Device is not in cart", result);
    }
}
