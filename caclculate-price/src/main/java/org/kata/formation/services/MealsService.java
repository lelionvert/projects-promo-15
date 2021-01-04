package org.kata.formation.services;

import org.kata.formation.entities.Price;
import org.kata.formation.entities.Stay;

import java.time.LocalTime;

public class MealsService {


    private final LocalTime lunchStartTime = DateTimeUtils.toTime("12:00");
    private final LocalTime lunchEndTime = DateTimeUtils.toTime("14:00");
    private final LocalTime dinnerStartTime = DateTimeUtils.toTime("19:00");
    private final LocalTime dinnerEndTime = DateTimeUtils.toTime("21:00");

    public Price calculateMealsPrice(Stay stay) {
        return null;
    }
}
