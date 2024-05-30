package org.example.springshop.controllers;

import org.example.springshop.services.DeviceService;
import org.example.springshop.services.IDeviceSrvice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.example.springshop.Device;
import org.example.springshop.Phone;
import org.example.springshop.Tablet;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private IDeviceSrvice deviceService;

    public DeviceController(IDeviceSrvice deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/all")
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }

    @GetMapping("/get/{model}")
    public Device getDevice(@PathVariable String model) {
        return deviceService.getDevice(model);
    }

    @PostMapping("/add/phone")
    public Device addPhone(@RequestBody Phone device) {
        return deviceService.addDevice(device);
    }

    @PostMapping("/add/tablet")
    public Device addTablet(@RequestBody Tablet device) {
        return deviceService.addDevice(device);
    }

    @DeleteMapping("/remove/{model}")
    public String removeDevice(@PathVariable String model) {
        return deviceService.removeDevice(model);
    }
}
