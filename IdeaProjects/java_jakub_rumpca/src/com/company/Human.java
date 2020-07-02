package com.company;

import com.company.creatures.Animal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Human {

    private Animal pet;
    private final Car[] garage;
    private Phone phone;
    private double cash;
    private Double salary = 2000.0;

    public Human() {
        garage = new Car[5];
    }

    public Human(int carPlaces) {
        garage = new Car[carPlaces];
    }

    public int getCarPlaces() {
        return garage.length;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Double getSalary() {
        System.out.println(String.format("Salary requested at %s, current value %s", new Date(), this.salary));
        return salary;
    }

    public void setSalary(Double salary) {

        if (salary < 0) {
            System.out.println("Are you ******* kidding me?");
        } else {
            System.out.println("New salary has been sent to accounting system");
            System.out.println("Mrs Hania has an annex for you ;]");
            System.out.println("Those thieves from ZUS and US already know ;/");
            this.salary = salary;
        }
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public Car[] getGarage() {
        return garage;
    }

    public Car getCar(int position) {
        return garage[position];
    }

    public void setCar(int position, Car car) {
        garage[position] = car;
    }

    public Double getCarsValue() {
        return Stream.of(garage).map(Car::getValue).reduce(0d, Double::sum);
    }

    public List<Car> getCarsByYearOfProduction() {
        return Stream.of(garage).sorted((a, b) -> {
            if (a.getYearOfProduction() == b.getYearOfProduction()) {
                return 0;
            } else {
                return a.getYearOfProduction() > b.getYearOfProduction() ? 1 : -1;
            }
        }).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Double.compare(human.getCash(), getCash()) == 0 &&
                Objects.equals(getPet(), human.getPet()) &&
                Objects.equals(garage, human.garage) &&
                Objects.equals(getPhone(), human.getPhone()) &&
                Objects.equals(getSalary(), human.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPet(), garage, getPhone(), getCash(), getSalary());
    }

    @Override
    public String toString() {
        return "Human{" +
                "pet=" + pet +
                ", garage=" + garage +
                ", phone=" + phone +
                ", cash=" + cash +
                ", salary=" + salary +
                '}';
    }
}
