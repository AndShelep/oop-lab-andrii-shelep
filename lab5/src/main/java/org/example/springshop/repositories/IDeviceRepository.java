package org.example.springshop.repositories;

import org.example.springshop.Device;

import java.util.List;

public interface IDeviceRepository {
    List<Device> getDevices();
    Device addDevice(Device device);
    String removeDevice(String model);
    Device getDevice(String model);
}
