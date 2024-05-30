package org.example.springshop;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class Order {
    @Getter @Setter
    protected String orderId;
    @Getter @Setter
    protected float price = 0.0f;
    @Getter @Setter
    protected float cashback = 0.0f;
    @Getter @Setter
    protected Client client;
    @Getter @Setter
    protected List<DeviceModel> devices = new ArrayList<>();

    public Order(List<DeviceModel> cart, float cashback, Client client){
        orderId = UUID.randomUUID().toString();
        this.client = client;
        this.cashback = cashback;
        for(var device : cart){
            devices.add(device);
            this.price += device.getPrice();
        }
    }

    protected void showDetails(){
        System.out.println("You ordered: ");
        for(var device : devices){
            device.mainDescription();
        }
        System.out.println("Price: " + price + " UAH");
        System.out.println("Cashback: " + String.format("%.2f", cashback) + " UAH");
        System.out.println("Recipient: " + client.name + " " + client.surname);
        System.out.println("Phone number: " + client.number);
        System.out.println("Email: " + client.email);
    }
}
