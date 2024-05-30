package org.example.springshop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    protected List<Device> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addToCart(Device device) {
        cart.add(device);
    }

    public void removeFromCart(Device device) {
        cart.remove(device);
    }

    public boolean isInCart(Device device){
        if (cart.contains(device)) return true;
        return false;
    }
}

