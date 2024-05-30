package org.example.springshop;

import lombok.Getter;
import lombok.Setter;

public class Phone extends Device {
    @Getter @Setter
    private int mainCamera;
    @Getter @Setter
    private int frontCamera;

    public Phone(String model, float price, int ram, float diagonal, int battery, int mainCamera, int frontCamera) {
        super(model, price, ram, diagonal, battery);
        this.mainCamera = mainCamera;
        this.frontCamera = frontCamera;
    }

    @Override
    public void description() {
        super.mainDescription();
        System.out.println("main camera: " + mainCamera + " MP\nfront camera: " + frontCamera + " MP\n");
    }
}

