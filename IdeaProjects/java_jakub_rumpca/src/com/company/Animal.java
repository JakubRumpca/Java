package com.company;

public class Animal {


    final String species;
    private Double weight;

    public Animal(String species, Double weight) {
        this.species = species;
        this.weight = weight;
    }

    public void feed() {
        if (this.weight <= 0) {
            System.out.println("Too late !! Fafik is in better place");
        } else {
            this.weight += 1.0;
        }
    }

    public void takeForAWalk() {
        if (this.weight <= 0) {
            System.out.println("Too late !! Fafik is in better place");
        } else {
            this.weight -= 1.0;
        }
    }
}

