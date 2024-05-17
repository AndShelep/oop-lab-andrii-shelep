package org.example.springshop.controllers;

import org.example.springshop.services.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.example.springshop.Device;
import org.example.springshop.Phone;
import org.example.springshop.Tablet;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
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
    public void addPhone(@RequestBody Phone device) {
        deviceService.addDevice(device);
    }

    @PostMapping("/add/tablet")
    public void addTablet(@RequestBody Tablet device) {
        deviceService.addDevice(device);
    }

    @DeleteMapping("/remove/{model}")
    public void removeDevice(@PathVariable String model) {
        deviceService.removeDevice(model);
    }
}
