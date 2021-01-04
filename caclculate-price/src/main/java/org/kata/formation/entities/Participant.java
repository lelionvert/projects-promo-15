package org.kata.formation.entities;

public class Participant {

    private final Accommodation accommodation;
    private final Stay stay;

    public Participant(Accommodation accommodation, Stay stay) {
        this.accommodation = accommodation;
        this.stay = stay;
    }

    public long countStayDays() {
        return stay.countDays();
    }

    public Price calculateStayPrice() {
        return Price.of(countStayDays() * accommodation.getPrice());
    }
}
