package repositories;

import entities.Participant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvParserTest {

    @Test
    public void should_extract_zero_participant_given_an_empty_file() {

        CsvParser parser =  new CsvParser("filePathWithNoParticipationYet.csv");

        List<Participant> participantList = parser.findAll();

        Assertions.assertEquals(0, participantList.size());
    }

    @Test
    public void should_return_participant_info_given_in_file_data() {

        CsvParser parser =  new CsvParser("filePathWithTwoLines.csv");

        List<Participant> participantList = parser.findAll();

        Assertions.assertEquals(2, participantList.size());
    }

    @Test
    public void should_return_two_participants_given_two_lines_in_file() {

        CsvParser parser =  new CsvParser("filePathWithTwoLines.csv");

        List<Participant> participantList = parser.findAll();

        Assertions.assertEquals(2, participantList.size());
    }

}