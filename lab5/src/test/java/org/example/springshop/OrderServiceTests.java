package org.example.springshop;

import org.example.springshop.repositories.OrderRepository;
import org.example.springshop.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTests {
    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOrderSucces() {
        Device device = new Phone("apple iphone 11", 15000f, 8, 8, 3000, 24, 12);
        Client client = new Client("12346", "Andrii", "Vilkosh", "+3806345654", "email@gmail.com");
        client.addToCart(device);

        when(orderRepository.addOrder(any(Order.class))).thenReturn("Order created");

        String result = orderService.createOrder(client);

        assertEquals("Order created", result);
    }

    @Test
    public void testCreateOrderFailure() {
        Client client = new Client("12346", "Andrii", "Vilkosh", "+3806345654", "email@gmail.com");

        String result = orderService.createOrder(client);

        assertEquals("There are no devices in carts", result);
    }
}
