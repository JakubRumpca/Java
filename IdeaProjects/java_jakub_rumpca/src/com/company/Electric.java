package com.company;

public class Electric extends Car {
    public Electric(String producer, String model, String color, int yearOfProduction, Double value) {
        super(producer, model, color, yearOfProduction, value);
    }

    @Override
    void refuel() {
        System.out.println("charged");
    }
}
