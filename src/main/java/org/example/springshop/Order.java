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
    protected float price;
    @Getter @Setter
    protected float deliveryPrice = 70.0f;
    @Getter @Setter
    protected float cashback;
    @Getter @Setter
    protected Client client;
    @Getter @Setter
    protected List<Device> devices = new ArrayList<>();

    public Order(float price, float cashback, float weight, List<Device> cart, Client client){
        orderId = UUID.randomUUID().toString();
        this.client = client;
        for(var device : cart){
            devices.add(device);
        }
        this.price = price;
        this.deliveryPrice += weight*100;
        this.cashback = cashback;
    }

    /*protected Order(float price, float cashback, float weight, Device device, Client client){
        orderId = UUID.randomUUID().toString();
        this.client = client;
        devices.add(device);
        this.price = price;
        this.deliveryPrice += weight*100;
        this.cashback = cashback;
    }*/

    protected void showDetails(){
        System.out.println("You ordered: ");
        for(var device : devices){
            device.mainDescription();
        }
        System.out.println("Price: " + price + " UAH");
        System.out.println("Price of the delivery: " + deliveryPrice + " UAH");
        System.out.println("Price with delivery: " + (price+deliveryPrice) + " UAH");
        System.out.println("Cashback: " + String.format("%.2f", cashback) + " UAH");
        System.out.println("Recipient: " + client.name + " " + client.surname);
        System.out.println("Phone number: " + client.number);
        System.out.println("Email: " + client.email);
    }
}
