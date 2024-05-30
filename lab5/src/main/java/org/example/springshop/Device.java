package org.example.springshop;

import java.util.ArrayList;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.abs;

public abstract class Device implements ITechnology, IColorControl {
    @Getter @Setter
    protected String model;
    @Getter @Setter
    protected float price;
    @Getter @Setter
    public String color;
    protected int ram;
    protected float diagonal;
    protected float battery;
    private ArrayList<String> colors = new ArrayList<>();

    public Device(String model, float price, int ram, float diagonal, int battery){
        this.model = model;
        this.price = price;
        this.color = "black";
        colors.add("black");
        this.ram = ram;
        this.diagonal = diagonal;
        this.battery = battery;
    }

    @Override
    public void setColors() {
        System.out.println("Enter the count of colors for device " + model);
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        for(int i = 0; i < count; i++){
            String color = scan.nextLine();
            if(colors.contains(color)){
                System.out.println("This color has already been added");
            } else {
                colors.add(color);
            }
        }
    }

    @Override
    public void changeColor(String color) {
        if(colors.contains(color)){
            this.color = color;
        } else {
            System.out.println("There is no such color for this device\n");
        }
    }

    @Override
    public float getCashback(){
        return price*0.001f;
    }

    public abstract void description();

    @Override
    public String mainDescription(){
        return model + "\ncolor: " + color + "\nprice: " + price + " UAH\n";
    }
}