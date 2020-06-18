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

        //test 5
        Human kuba = new Human();
        Car porsche = new Car("Porsche", "911", "Red");
        porsche.setValue(450000.0);
        kuba.setCar(porsche);
        kuba.setSalary(300000.0);
        kuba.setCar(porsche);
        kuba.setSalary(500000.0);
        kuba.setCar(porsche);


        //test 3 and 4
        kuba.setSalary(-1000.0);
        kuba.setSalary(15000.0);
        kuba.getSalary();

        //test 6
        System.out.println(kuba);
        Car macan = new Car("Porsche", "Macan", "Black");
        macan.setValue(250000d);
        Car cayenne = new Car("Porsche", "Cayenne", "Black");
        cayenne.setValue(550000d);
        Car secondMacan = new Car("Porsche", "Macan", "Black");
        secondMacan.setValue(250000d);

        System.out.println(macan.equals(cayenne));
        System.out.println(macan.equals(secondMacan));
        System.out.println(macan.equals(macan));

    }


}
