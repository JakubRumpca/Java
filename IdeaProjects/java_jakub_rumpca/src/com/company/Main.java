package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Pet;
import com.company.device.Device;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

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
        Car porsche = new Electric("Porsche", "911", "Red", 2020, 450000.0);
        // not relevant anymore
//        kuba.setCar(porsche);
//        kuba.setSalary(300000.0);
//        kuba.setCar(porsche);
//        kuba.setSalary(500000.0);
//        kuba.setCar(porsche);


        //test 3 and 4
        kuba.setSalary(-1000.0);
        kuba.setSalary(15000.0);
        kuba.getSalary();

        //test 6
        System.out.println(kuba);
        Car macan = new Diesel("Porsche", "Macan", "Black", 2018, 250000d);
        Car cayenne = new Diesel("Porsche", "Cayenne", "Black", 2019, 550000d);
        Car secondMacan = new Diesel("Porsche", "Macan", "Black", 2020, 250000d);

        System.out.println(macan.equals(cayenne));
        System.out.println(macan.equals(secondMacan));
        System.out.println(macan.equals(macan));

        // test 7
        Device device = new Phone("Iphone X", "Apple", 2019, 4500d);
        device.turnOn();

        //test 8
        Phone iphone = new Phone("Iphone 3s", "Apple", 2008, 300d);
        Car opel = new LPG("Opel", "Corsa", "pink", 2001, 800d);
        Animal horse = new FarmAnimal("Kon Polski", 500d);
        Animal frog = new Pet("Ropucha", 0.5d);

        Human zygmunt = new Human();
        zygmunt.setCash(8000);
        zygmunt.setPhone(iphone);
        zygmunt.setPet(horse);

        Human czeslaw = new Human();
        czeslaw.setCash(200);
        czeslaw.setCar(0, opel);

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

        // test 11
        Human andrew = new Human(3);
        Car mustang = new LPG("Ford", "Mustang", "black", 1970, 250000d);
        Car audi = new Electric("Audi", "Etron", "black", 2020, 500000d);
        andrew.setCar(0, new Diesel("Audi", "RS6", "black", 2019, 750000d));
        andrew.setCar(1, audi);
        andrew.setCar(2, mustang);
        try {
            andrew.setCar(3, new Diesel("Audi", "RS6", "black", 2020, 750000d));
        } catch (RuntimeException ex) {
            System.out.println("caught exception, number of cars attempted to park in a garage exceeds it's capacity");
        }

        System.out.println("Total cars value: " + andrew.getCarsValue());

        System.out.println("Ordered list of cars by year of production (ascending)" + andrew.getCarsByYearOfProduction());


        Human jhon = new Human(1);
        // Jhon doesn't have enough money
        jhon.setCash(35000d);
        try {
            mustang.sell(jhon, andrew, 275000d);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        jhon.setCash(350000d);
        mustang.sell(jhon, andrew, 275000d);

        //Andrew cannot sell a car he doesn't own
        Car daihatsu = new LPG("Daihatsu", "XYZ", "?", 1995, 123.50);
        try {
            daihatsu.sell(jhon, andrew, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Jhon's garage is full
        try {
            audi.sell(jhon, andrew, 500000d);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //test 12
        Human tom = new Human(3);
        Car nissan = new LPG("Nissan", "350Z", "black", 2005, 50000d);
        Car bmw = new Electric("BMW", "5", "black", 2020, 500000d);
        tom.setCar(0, new Diesel("Audi", "RS6", "black", 2019, 750000d));
        tom.setCar(1, nissan);
        tom.setCar(2, bmw);

        Human lisa = new Human(1);
        lisa.setCash(1000000d);
        nissan.sell(lisa, tom, 50000d);

        nissan.sellTransaction(lisa, tom);
        try {
            bmw.sellTransaction(lisa, tom);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Human amber = new Human(1);
        amber.setCash(45000d);
        nissan.sell(amber, lisa, 45000d);

        System.out.println("Was there transaction between lisa and tom? " + nissan.sellTransaction(lisa, tom));

        System.out.println("Number of transactions with Nissan : " + nissan.sellTransactionCount());

        assert !nissan.wasOwner(jhon);
        assert nissan.wasOwner(tom);


        // test 13
        Human jacob = new Human();
        jacob.setCash(10000d);

        Phone x = new Phone("Iphone X", "Apple", 2020, 4500d);
        Application googleMaps = new Application("google Maps", "24.23", 0d);
        Application uber = new Application("uber", "10.1", 0d);
        Application msOfficeMobile = new Application("office mobile", "16", 60d);
        Application superMario = new Application("super mario", "1.0.1", 10d);
        Application abc = new Application("abc", "1.0.1", 10d);

        x.install(googleMaps, jacob);
        x.install(uber, jacob);
        x.install(msOfficeMobile, jacob);
        x.install(superMario, jacob);

        System.out.println("Is GoogleMaps app installed: " + x.isInstalled(googleMaps));
        System.out.println("Is abc app installed: " + x.isInstalled(abc));
        System.out.println("Is Angry Birds app installed: " + x.isInstalled("Angry Birds"));
        System.out.println("Is Uber app installed: " + x.isInstalled("uber"));
        System.out.println("free apps: " + x.getFreeApps());
        System.out.println("total apps value: " + x.appsValue());
        System.out.println("apps in alphabetical order " + x.appNamesInAlphabeticalOrder());
        System.out.println("apps by price " + x.appNamesByPrice());

    }


}
