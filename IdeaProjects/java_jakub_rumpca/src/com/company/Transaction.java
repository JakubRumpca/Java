package com.company;

import java.time.OffsetDateTime;

public class Transaction {
    private final Human buyer;
    private final Human seller;
    private final double price;
    private final OffsetDateTime transactionDate;

    public Transaction(Human buyer, Human seller, double price, OffsetDateTime transactionDate) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.transactionDate = transactionDate;
    }

    public Human getBuyer() {
        return buyer;
    }

    public Human getSeller() {
        return seller;
    }

    public double getPrice() {
        return price;
    }

    public OffsetDateTime getTransactionDate() {
        return transactionDate;
    }
}
