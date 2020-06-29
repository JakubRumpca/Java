package com.company;

import java.util.Objects;

public class Animal implements Sellable {

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

    @Override
    public void sell(Human buyer, Human seller, double price) {

        if (!seller.getPet().equals(this)) {
            System.out.println("Seller doesn't own the animal he is going to sell");
            return;
        }

        if (buyer.getCash() < price) {
            System.out.println("Buyer can not afford the animal");
            return;
        }

        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);

        buyer.setPet(seller.getPet());
        seller.setPet(null);

        System.out.println(String.format("An animal has been sold for %s$", price));
    }
}

