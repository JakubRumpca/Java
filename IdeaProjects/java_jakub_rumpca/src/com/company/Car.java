package com.company;

public class Car {

    final String model;
    final String color;
    final String producer;
    private Double value;

    public Car(String producer, String model, String color) {
        this.model = model;
        this.color = color;
        this.producer = producer;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
