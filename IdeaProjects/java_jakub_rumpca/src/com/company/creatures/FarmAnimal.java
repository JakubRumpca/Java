package com.company.creatures;

public class FarmAnimal extends Animal implements Edbile {

    public FarmAnimal(String species, Double weight) {
        super(species, weight);
    }

    @Override
    public void beEaten() {
        System.out.println(String.format("%s tasted well", species));
    }
}
