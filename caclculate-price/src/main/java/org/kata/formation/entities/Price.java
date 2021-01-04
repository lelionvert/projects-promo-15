package org.kata.formation.entities;

import java.util.Objects;

public class Price {

    private final long amount;

    private Price(long amount) {
        this.amount = amount;
    }

    public static Price of(long amount) {
        return new Price(amount);
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return amount == price.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
