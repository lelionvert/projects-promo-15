package example;

import entities.Participant;

import java.util.List;

@FunctionalInterface
public interface ParticipationRepository {
    List<Participant> findAll();
}
