package org.example.springshop.services;

import org.example.springshop.Device;
import org.example.springshop.HashTable;
import org.example.springshop.Phone;
import org.example.springshop.Tablet;
import org.example.springshop.repositories.DeviceRepository;
import org.example.springshop.repositories.IDeviceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService implements IDeviceSrvice{
    private IDeviceRepository deviceRepository;

    public DeviceService(IDeviceRepository deviceRepository) {
        this.deviceRepository = DeviceRepository.getInstance();
    }

    @Override
    public List<Device> getDevices() {
        return deviceRepository.getDevices();
    }

    @Override
    public Device addDevice(Device device) {
        return deviceRepository.addDevice(device);
    }

    @Override
    public String removeDevice(String model) {
        return deviceRepository.removeDevice(model);
    }

    @Override
    public Device getDevice(String model) {
        return deviceRepository.getDevice(model);
    }
}
