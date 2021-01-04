package org.kata.formation.entities;

public class Accommodation {
    private final String type;
    private final Price price;

    private Accommodation(String type, Price price) {
        this.type = type;
        this.price = price;
    }

    public static Accommodation of(String type, Price price) {
        return new Accommodation(type, price);
    }

    public long getPrice() {l
        return price.getAmount();
    }
}
