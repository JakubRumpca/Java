package com.company;

public class LPG extends Car {
    public LPG(String producer, String model, String color, int yearOfProduction) {
        super(producer, model, color, yearOfProduction);
    }

    @Override
    void refuel() {
        System.out.println("Booooomm");
    }
}
