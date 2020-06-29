package com.company;

public class Diesel extends Car {
    public Diesel(String producer, String model, String color, int yearOfProduction) {
        super(producer, model, color, yearOfProduction);
    }

    @Override
    void refuel() {
        System.out.println("Eco diesel tanked");
    }
}
