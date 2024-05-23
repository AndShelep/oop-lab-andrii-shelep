package org.example.springshop;

import org.example.springshop.repositories.DeviceRepository;
import org.example.springshop.services.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertNull;

@SpringBootTest
public class DeviceServiceTests {
    @Mock
    private DeviceRepository deviceRepository;
    @InjectMocks
    private DeviceService deviceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPhone() {
        Device device = new Phone("apple iphone 13", 25000f, 16, 10, 3600, 0.3f, 24, 12);
        when(deviceService.addDevice(device)).thenReturn(device);

        Device result = deviceService.addDevice(device);

        assertEquals(device, result);
    }

    @Test
    public void testFindDeviceSuccess() {
        Device expectedDevice = new Phone("apple iphone 11", 15000f, 8, 8, 3000, 0.3f, 24, 12);
        when(deviceService.getDevice("apple iphone 11")).thenReturn(expectedDevice);

        Device result = deviceService.getDevice("apple iphone 11");

        assertEquals(expectedDevice, result);
    }

    @Test
    public void testFindDeviceFailure() {
        when(deviceService.getDevice("apple iphone X")).thenReturn(null);

        Device result = deviceService.getDevice("apple iphone X");

        assertEquals(null, result);
    }

    @Test
    public void testRemoveDeviceSuccess() {
        when(deviceService.removeDevice("apple iphone 15 pro max")).thenReturn("Device removed");

        String result = deviceService.removeDevice("apple iphone 15 pro max");

        assertEquals("Device removed", result);
    }

    @Test
    public void testRemoveDeviceFailure() {
        when(deviceService.removeDevice("apple iphone X")).thenReturn("Device not found");

        String result = deviceService.removeDevice("apple iphone X");

        assertEquals("Device not found", result);
    }
}
