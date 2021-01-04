package example;

import entities.Participant;

import java.util.List;

public class CsvParticipationRepository implements ParticipationRepository {

    private final String csvPath;

    public CsvParticipationRepository(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public List<Participant> findAll() {
        return null;
    }
}
