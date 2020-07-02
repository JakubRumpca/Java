package com.company.device;

import com.company.Sellable;

public abstract class Device implements Sellable {

    final String model;
    final String producer;
    private final Double value;
    final int yearOfProduction;

    public Device(String model, String producer, int yearOfProduction, Double value) {
        this.model = model;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }

    public String getModel() {
        return model;
    }

    public String getProducer() {
        return producer;
    }

    public Double getValue() {
        return value;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public abstract void turnOn();

    @Override
    public String toString() {
        return "Device{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
