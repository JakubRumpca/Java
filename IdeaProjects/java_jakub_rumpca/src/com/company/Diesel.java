package com.company;

public class Diesel extends Car {
    public Diesel(String producer, String model, String color, int yearOfProduction, Double value) {
        super(producer, model, color, yearOfProduction, value);
    }

    @Override
    void refuel() {
        System.out.println("Eco diesel tanked");
    }
}
