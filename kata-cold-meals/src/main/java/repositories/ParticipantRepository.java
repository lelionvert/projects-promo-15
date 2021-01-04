package repositories;

import entities.Participant;

import java.util.List;

public interface ParticipantRepository {

    List<Participant> findAll();
}
