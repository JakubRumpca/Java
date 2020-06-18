package com.company;

import java.util.Objects;

public class Phone {

    final String model;
    final String producer;

    public Phone(String model, String producer) {
        this.model = model;
        this.producer = producer;
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
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
