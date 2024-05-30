package org.example.springshop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    protected List<Device> cart;
    public ShoppingCart() {
        cart = new ArrayList<>();
    }
    void addToCart(Device device) {
        cart.add(device);
    }
    void removeFromCart(Device device) {
        cart.remove(device);
    }

    void removeFromCart(int ind) {
        cart.remove(ind);
    }
}

