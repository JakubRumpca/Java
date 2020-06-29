package com.company;

import com.company.device.Device;

import java.util.Objects;

public abstract class Car extends Device {

    final String model;
    final String color;
    final String producer;
    private Double value;
    private final String vinNumber;

    public Car(String producer, String model, String color, int yearOfProduction) {
        super(model, producer, yearOfProduction);
        this.model = model;
        this.color = color;
        this.producer = producer;
        vinNumber = Math.random() * 1000000 + "";
    }

    abstract void refuel();

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(producer, car.producer) &&
                Objects.equals(getValue(), car.getValue()) &&
                Objects.equals(vinNumber, car.vinNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, producer, getValue(), vinNumber);
    }

    @Override
    public void turnOn() {
        System.out.println("Car turned on");
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", producer='" + producer + '\'' +
                ", value=" + value +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }

    @Override
    public void sell(Human buyer, Human seller, double price) {
        if (!seller.getCar().equals(this)) {
            System.out.println("Seller doesn't own the car he is going to sell");
            return;
        }

        if (buyer.getCash() < price) {
            System.out.println("Buyer can not afford the car");
            return;
        }

        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);

        buyer.setCar(seller.getCar());
        seller.setCar(null);

        System.out.println(String.format("An car has been sold for %s$", price));

    }
}
