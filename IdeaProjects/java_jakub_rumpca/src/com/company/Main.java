package com.company;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("dog", 2.0);

        //test
        for (int i = 0; i < 4; i++) {
            animal.feed();
        }

        for (int j = 0; j < 6; j++) {
            animal.takeForAWalk();
        }

        animal.feed();

        Human kuba = new Human();
        kuba.setCar(new Car("Porsche", "911", "Red" ));
    }


}
