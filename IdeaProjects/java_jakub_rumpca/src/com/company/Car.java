package com.company;

import com.company.device.Device;

import java.util.Objects;
import java.util.stream.Stream;

public abstract class Car extends Device {

    final String model;
    final String color;
    final String producer;

    private final String vinNumber;

    public Car(String producer, String model, String color, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
        this.model = model;
        this.color = color;
        this.producer = producer;
        vinNumber = Math.random() * 1000000 + "";
    }

    abstract void refuel();

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
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }

    @Override
    public void sell(Human buyer, Human seller, double price) {
        if (Stream.of(seller.getGarage()).filter(Objects::nonNull).noneMatch(car -> car.equals(this))) {
            throw new RuntimeException("Seller doesn't own the car he is going to sell");
        }

        if (Stream.of(buyer.getGarage()).filter(Objects::nonNull).count() >= buyer.getGarage().length) {
            throw new RuntimeException("Not enough space in buyer's garage");
        }

        if (buyer.getCash() < price) {
            throw new RuntimeException("Buyer can not afford the car");
        }

        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);

        for (int i = 0; i < buyer.getGarage().length; i++) {
            if(buyer.getGarage()[i] == null) {
                buyer.getGarage()[i] = this;
                break;
            }
        }

        for (int i = 0; i < seller.getGarage().length; i++) {
            if(seller.getGarage()[i] == this) {
                seller.getGarage()[i] = null;
                break;
            }
        }

        System.out.println(String.format("An car has been sold for %s$", price));

    }
}
