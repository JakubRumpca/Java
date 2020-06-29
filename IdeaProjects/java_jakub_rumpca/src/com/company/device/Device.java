package com.company.device;

import com.company.Sellable;

public abstract class Device implements Sellable {

    final String model;
    final String producer;
    final int yearOfProduction;

    public Device(String model, String producer, int yearOfProduction) {
        this.model = model;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
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
