package org.example.springshop;

import java.util.UUID;

public class DeviceModelAdapter {
    public DeviceModel toDeviceModel(Device device) {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.serialNumber = UUID.randomUUID().toString();
        deviceModel.model = device.getModel();
        deviceModel.setColor(device.getColor());
        deviceModel.setPrice(device.getPrice());
        return deviceModel;
    }
}
