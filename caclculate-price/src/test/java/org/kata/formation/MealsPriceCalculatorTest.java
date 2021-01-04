package org.kata.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kata.formation.entities.Price;
import org.kata.formation.entities.Stay;
import org.kata.formation.services.MealsService;

import static org.kata.formation.services.DateTimeUtils.toDateTime;

public class MealsPriceCalculatorTest {

    private MealsService mealsService;


    @BeforeEach
    void setUp() {
        this.mealsService = new MealsService();
    }

    @Test
    public void should_calculate_meals_price_given_a_stay_of_days() {

        Stay stay = Stay.of(toDateTime("17-12-2020 9:30"), toDateTime("20-12-2020 14:30"));

        Price price = mealsService.calculateMealsPrice(stay);

        Assertions.assertEquals(Price.of(240), price);

    }

    @Test
    public void should_calculate_two_meals_price_given_a_stay_on_one_complete_day() {

        Stay stay = Stay.of(toDateTime("18-12-2020 9:30"), toDateTime("18-12-2020 20:30"));

        Price price = mealsService.calculateMealsPrice(stay);

        Assertions.assertEquals(Price.of(80), price);

    }

}
