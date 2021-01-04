package example;

import entities.Participant;

import java.util.List;

@FunctionalInterface
public interface ColdMealsCounter {
    int count(final List<Participant> participants);
}
