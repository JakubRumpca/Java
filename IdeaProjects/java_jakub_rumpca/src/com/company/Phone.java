package com.company;

import com.company.device.Device;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Phone extends Device {

    private static final String DEFAULT_SERVER = "server.com/apps";
    private static final String DEFAULT_PROTOCOL = "https";
    private static final String DEFAULT_VERSION  = "1.0";

    final String model;
    final String producer;
    private final List<Application> apps = new ArrayList<>();

    public Phone(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
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

    public void install(Application app, Human buyer) {
        if (buyer.getCash() < app.getPrice()) {
            throw new RuntimeException("This guy cannot afford the app " + app.getName());
        }

        apps.add(app);
        buyer.setCash(buyer.getCash() - app.getPrice());
    }

    public boolean isInstalled(Application app) {
        return apps.contains(app);
    }

    public boolean isInstalled(String appName) {
        return apps.stream().anyMatch(app -> app.getName().equals(appName));
    }

    public List<Application> getFreeApps(){
        return apps.stream().filter(app -> app.getPrice() == 0d).collect(Collectors.toList());
    }

    public double appsValue(){
        return apps.stream().map(Application::getPrice).reduce(0d, Double::sum);
    }

    public List<String> appNamesInAlphabeticalOrder(){
        return apps.stream().map(Application::getName).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public List<String> appNamesByPrice(){
        return apps.stream().sorted((a, b) -> {
            if (a.getPrice() == b.getPrice()) {
                return 0;
            } else {
                return a.getPrice() < b.getPrice() ? -1 : 1;
            }
        }).map(Application::getName).collect(Collectors.toList());
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
