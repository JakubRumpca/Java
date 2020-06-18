package com.company;

import java.util.Date;

public class Human {

    private Animal pet;
    private Car car;

    private Double salary = 2000.0;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
