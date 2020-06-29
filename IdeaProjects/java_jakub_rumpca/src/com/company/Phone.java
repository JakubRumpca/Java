package com.company;

import com.company.device.Device;

import java.net.URL;
import java.util.List;
import java.util.Objects;

public class Phone extends Device {

    private static final String DEFAULT_SERVER = "server.com/apps";
    private static final String DEFAULT_PROTOCOL = "https";
    private static final String DEFAULT_VERSION  = "1.0";

    final String model;
    final String producer;

    public Phone(String model, String producer, int yearOfProduction) {
        super(model, producer, yearOfProduction);
        this.model = model;
        this.producer = producer;
    }

    public void installAnnApp(String name) {
        install(name, DEFAULT_VERSION, String.format("%s://%s", DEFAULT_PROTOCOL, DEFAULT_SERVER));
    }

    public void installAnnApp(String name, String version) {
        install(name, version, String.format("%s://%s", DEFAULT_PROTOCOL, DEFAULT_SERVER));
    }

    public void installAnnApp(String name, String version, String server) {
        install(name, version, server);
    }

    public void installAnnApp(List<String> appNames) {
        appNames.forEach(this::installAnnApp);
    }

    public void installAnnApp(URL appsURL) {
        install(appsURL.getPath(), DEFAULT_VERSION, appsURL.toString());
    }

    private void install(String name, String version, String server ){
        System.out.println(String.format("App %s v%s installed from %s", name, version, server));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(model, phone.model) &&
                Objects.equals(producer, phone.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, producer);
    }

    @Override
    public void turnOn() {
        System.out.println("Phone turned on");
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }

    @Override
    public void sell(Human buyer, Human seller, double price) {
        if (!seller.getPhone().equals(this)) {
            System.out.println("Seller doesn't own the phone he is going to sell");
            return;
        }

        if (buyer.getCash() < price) {
            System.out.println("Buyer can not afford the phone");
            return;
        }

        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);

        buyer.setPhone(seller.getPhone());
        seller.setPhone(null);

        System.out.println(String.format("A phone has been sold for %s$", price));
    }
}
