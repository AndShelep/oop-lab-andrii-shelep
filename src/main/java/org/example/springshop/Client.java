package org.example.springshop;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class Client {
    @Getter @Setter
    protected String id;
    @Getter @Setter
    protected String name;
    @Getter @Setter
    protected String surname;
    @Getter @Setter
    protected String number;
    @Getter @Setter
    protected String email;
    protected ShoppingCart cart;
    public Client(String id, String name, String surname, String number, String email){
        //this.id = UUID.randomUUID().toString();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        cart = new ShoppingCart();
    }

    public void addToCart(Device device){
        cart.addToCart(device);
    }

    public void removeFromCart(Device device){
        cart.removeFromCart(device);
    }

    public boolean isInCart(Device device){
        if (cart.cart.contains(device)) return true;
        return false;
    }

    public List<Device> showCart(){
        return cart.cart;
    }
}
