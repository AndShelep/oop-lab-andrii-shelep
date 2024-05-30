package org.example.springshop;


import lombok.Getter;
import lombok.Setter;

public class DeviceModel {
    protected String serialNumber;
    @Getter @Setter
    protected String model;
    @Getter @Setter
    private String color;
    @Getter @Setter
    private float price;

    public DeviceModel() {}

    public void mainDescription(){
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
    }
}
