package example;

import entities.Participant;

import java.util.List;

public class Kitchen {

    private final ParticipationRepository participationRepository;
    private final ColdMealsCounter coldMealsCounter;

    public Kitchen(ParticipationRepository participationRepository, ColdMealsCounter coldMealsCounter) {
        this.participationRepository = participationRepository;
        this.coldMealsCounter = coldMealsCounter;
    }

    public int countColdMeals() {
        List<Participant> participants = participationRepository.findAll();
        return coldMealsCounter.count(participants);
    }
}
