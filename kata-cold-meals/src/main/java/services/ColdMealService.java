package services;

import entities.Participant;
import repositories.CsvParser;

import java.util.List;

public class ColdMealService {

    private final CsvParser parser = new CsvParser();

    public int countColdMeal(String filePath) {
        List<Participant> participants = parser.getParticipations(filePath);
        if(participants.size() == 0 || noCheckinYet(participants) || isAllCheckinInTime(participants, 21)) {
            return 0;
        }
        return -1;
    }

    private boolean isAllCheckinInTime(List<Participant> participantList, int limitHour) {
        for(Participant participant : participantList) {
            if(!participant.isCheckinBefore(limitHour)) {
                return false;
            }
        }
        return true;
    }

    private boolean noCheckinYet(List<Participant> participantList) {
        for(Participant participant : participantList) {
            if(participant.hasCheckin()) {
                return false;
            }
        }
        return true;
    }
}
