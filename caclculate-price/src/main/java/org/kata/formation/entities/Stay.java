package org.kata.formation.entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Stay {
    private final LocalDateTime checkin;
    private final LocalDateTime checkout;

    public Stay(LocalDateTime checkin, LocalDateTime checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public static Stay of(LocalDateTime checkin, LocalDateTime checkout) {
        return new Stay(checkin, checkout);
    }

    public long countDays() {
        return ChronoUnit.DAYS.between(checkin.toLocalDate(), checkout.toLocalDate()) + 1;
    }
}
