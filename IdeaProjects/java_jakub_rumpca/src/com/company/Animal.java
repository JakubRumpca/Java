package com.company;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(species, animal.species) &&
                Objects.equals(weight, animal.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, weight);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }
}

