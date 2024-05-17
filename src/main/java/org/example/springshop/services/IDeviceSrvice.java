package org.example.springshop.services;

import java.util.List;
import org.example.springshop.Device;

public interface IDeviceSrvice {
    public List<Device> getDevices();
    public void addDevice(Device device);
    public void removeDevice(String model);
    public Device getDevice(String model);
}
