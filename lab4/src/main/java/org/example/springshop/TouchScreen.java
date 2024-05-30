package org.example.springshop;

import lombok.Getter;
import lombok.Setter;

public abstract class TouchScreen extends Device{
    @Getter @Setter
    private float diagonal;
    @Getter @Setter
    private int battery;
    @Getter @Setter
    private int ram;
    @Getter @Setter
    private int memory;
    private final int[] memories = {64, 128, 256, 512};

    public TouchScreen(String model, float price, int ram, float diagonal, int battery, float weight) {
        super(model, price, weight);
        this.diagonal = diagonal;
        this.battery = battery;
        this.memory = 64;
        this.ram = ram;
    }

    @Override
    public void description() {
        System.out.println(model + "\ncolor: " + color + "\nprice: " + price + " UAH" + "\nweight: " + weight + "kg");
        System.out.println("memory: " + memory + " gb\nRAM: " + ram + " gb\ndisplay diagonal: " + diagonal + "\"\nbattery: " + battery + " mAh");
    }

    public void chooseMemory(int mem){
        boolean isPresent = false;
        for(int i = 0; i < memories.length; i++){
            if(mem == memories[i]){
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            System.out.println("there is no phone with " + mem + " gb of memory");
        } else {
            if(mem > memory){
                price = price + mem*1000/memory;
            } else {
                price = price - memory*1000/mem;
            }
            memory = mem;
        }
    }
}
