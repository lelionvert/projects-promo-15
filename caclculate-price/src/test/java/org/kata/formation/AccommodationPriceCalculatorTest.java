package org.kata.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kata.formation.entities.Accommodation;
import org.kata.formation.entities.Price;
import org.kata.formation.entities.Participant;
import org.kata.formation.entities.Stay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccommodationPriceCalculatorTest {

    @Test
    public void should_calculate_accommodation_type_price_given_participant_having_a_stay_of_days() {

        Accommodation accommodation = Accommodation.of("Single", Price.of(600));
        Stay stay = Stay.of(toDate("17-12-2020 14:30"), toDate("20-12-2020 14:30"));
        Participant participant = new Participant(accommodation, stay);

        Price price = participant.calculateStayPrice();

        Assertions.assertEquals(Price.of(2400), price);

    }

    @Test
    public void should_calculate_price_given_participant_with_fixed_accommodation_type_and_having_a_stay_of_days() {

        Accommodation accommodation = Accommodation.of("No Accommodation", Price.of(200));
        Stay stay = Stay.of(toDate("17-12-2020 14:00"), toDate("17-12-2020 20:00"));
        Participant participant = new Participant(accommodation, stay);

        Price price = participant.calculateStayPrice();

        Assertions.assertEquals(Price.of(200), price);

    }

    @Test
    public void should_calculate_price_given_participant_with_different_accommodation_types_and_fixed_stay_duration() {

        Accommodation accommodation = Accommodation.of("No Accommodation", Price.of(200));
        Stay stay = Stay.of(toDate("17-12-2020 14:00"), toDate("19-12-2020 20:00"));
        Participant participant = new Participant(accommodation, stay);

        Price price = participant.calculateStayPrice();

        Assertions.assertEquals(Price.of(600), price);

    }

    private LocalDateTime toDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(dateString, formatter);
    }

}
