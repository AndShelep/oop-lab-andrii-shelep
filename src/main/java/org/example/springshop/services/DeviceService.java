package org.example.springshop.services;

import org.example.springshop.Device;
import org.example.springshop.HashTable;
import org.example.springshop.Phone;
import org.example.springshop.Tablet;
import org.example.springshop.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService implements IDeviceSrvice{
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> getDevices() {
        return deviceRepository.getDevices();
    }

    @Override
    public void addDevice(Device device) {
        deviceRepository.addDevice(device);
    }

    @Override
    public void removeDevice(String model) {
        Device device = deviceRepository.getDevice(model);
        if (device != null) {
            deviceRepository.removeDevice(device);
        }
    }

    @Override
    public Device getDevice(String model) {
        return deviceRepository.getDevice(model);
    }
}
