package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Pet;
import com.company.device.Device;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Pet("dog", 2.0);

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
        Car porsche = new Electric("Porsche", "911", "Red", 2020);
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
        Car macan = new Diesel("Porsche", "Macan", "Black", 2018);
        macan.setValue(250000d);
        Car cayenne = new Diesel("Porsche", "Cayenne", "Black", 2019);
        cayenne.setValue(550000d);
        Car secondMacan = new Diesel("Porsche", "Macan", "Black", 2020);
        secondMacan.setValue(250000d);

        System.out.println(macan.equals(cayenne));
        System.out.println(macan.equals(secondMacan));
        System.out.println(macan.equals(macan));

        // test 7
        Device device = new Phone("Iphone X", "Apple", 2019 );
        device.turnOn();

        //test 8
        Phone iphone = new Phone("Iphone 3s", "Apple", 2008);
        Car opel = new LPG("Opel", "Corsa", "pink", 2001);
        opel.setValue(800d);
        Animal horse = new FarmAnimal("Kon Polski", 500d);
        Animal frog = new Pet("Ropucha", 0.5d);

        Human zygmunt = new Human();
        zygmunt.setCash(8000);
        zygmunt.setPhone(iphone);
        zygmunt.setPet(horse);

        Human czeslaw = new Human();
        czeslaw.setCash(200);
        czeslaw.setCar(opel);

        iphone.sell(czeslaw, zygmunt, 1000);
        czeslaw.setCash(200000);

        iphone.sell(czeslaw, zygmunt, 1000);
        opel.sell(zygmunt, czeslaw, 800);
        frog.sell(czeslaw, zygmunt, 1);
        horse.sell(czeslaw, zygmunt, 20000);

        //test 9
        Animal crazyFrog = new Pet("Ropucha", 0.5d);
        crazyFrog.feed(0.3);
        crazyFrog.feed();
        crazyFrog.takeForAWalk();
        crazyFrog.takeForAWalk();
        crazyFrog.feed(0.9);

        FarmAnimal crazyHorse = new FarmAnimal("Kon Polski", 500d);
        crazyHorse.beEaten();

        //test 10
        iphone.installAnnApp("abc");
        iphone.installAnnApp("abc", "2.25");
        iphone.installAnnApp("abc", "4.3", "https://cheap-games/mario");
        iphone.installAnnApp(Arrays.asList("app1", "app2"));
        try {
            iphone.installAnnApp(new URL("https", "games-server", "app5"));
        } catch (MalformedURLException e) {
            System.out.println("Incorrect app URL");
            e.printStackTrace();
        }

        porsche.refuel();
        opel.refuel();
        macan.refuel();

    }


}
