package org.example.springshop;

public class Tablet extends Device{
    private final float cashbackCoef = 0.003f;

    public Tablet(String model, float price, int ram, float diagonal, int battery) {
        super(model, price, ram, diagonal, battery);
    }

    @Override
    public float getCashback() {
        return price*cashbackCoef;
    }

    @Override
    public void description() {
        super.mainDescription();
        System.out.println();
    }
}
