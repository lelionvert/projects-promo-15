package example;

import entities.Participant;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvParticipantRepositoryTest {

    @Test
    void should_empty() {
        CsvParticipationRepository csvParticipationRepository = new CsvParticipationRepository("resources/empty-participations.csv");

        List<Participant> participantRepositoryAll = csvParticipationRepository.findAll();
    }
}