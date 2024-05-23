package org.example.springshop.services;

import java.util.List;
import org.example.springshop.Device;

public interface IDeviceSrvice {
    public List<Device> getDevices();
    public Device addDevice(Device device);
    public String removeDevice(String model);
    public Device getDevice(String model);
}
