package org.example.springshop.repositories;

import lombok.Getter;
import org.example.springshop.Device;
import org.example.springshop.HashTable;
import org.example.springshop.Phone;
import org.example.springshop.Tablet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeviceRepository implements IDeviceRepository {
    @Getter
    public List<Device> devices = new ArrayList<Device>();
    private static DeviceRepository instance;
    public HashTable table = new HashTable();

    private DeviceRepository() {
        devices.add(new Phone("apple iphone 11", 15000f, 8, 8, 3000, 24, 12));
        devices.add(new Phone("apple iphone 15 pro max", 60000f, 8, 8, 4000, 48, 24));
        devices.add(new Tablet("Samsung Galaxy tab", 8000, 8, 10, 3500));

        for(Device d : devices) {
            table.put(d);
        }
    }

    //singleton
    public static synchronized DeviceRepository getInstance() {
        if (instance == null) {
            instance = new DeviceRepository();
        }
        return instance;
    }

    @Override
    public List<Device> getDevices() {
        return devices;
    }

    @Override
    public Device addDevice(Device device) {
        devices.add(device);
        table.put(device);
        return device;
    }

    @Override
    public String removeDevice(String model) {
        Device device = table.get(model);
        devices.remove(device);
        return table.remove(model);
    }

    @Override
    public Device getDevice(String model) {
        return table.get(model);
    }
}
