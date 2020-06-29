package com.company;

public class Electric extends Car {
    public Electric(String producer, String model, String color, int yearOfProduction) {
        super(producer, model, color, yearOfProduction);
    }

    @Override
    void refuel() {
        System.out.println("charged");
    }
}
