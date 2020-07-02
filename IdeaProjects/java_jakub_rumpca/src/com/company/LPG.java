package com.company;

public class LPG extends Car {
    public LPG(String producer, String model, String color, int yearOfProduction, Double value) {
        super(producer, model, color, yearOfProduction, value);
    }

    @Override
    void refuel() {
        System.out.println("Booooomm");
    }
}
