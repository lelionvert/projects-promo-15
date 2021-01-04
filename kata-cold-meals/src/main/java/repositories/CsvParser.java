package repositories;

import entities.Participant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements ParticipantRepository {

    public static final String DATE_TIME_SEPARATOR = " ";
    public static final String DATE_SEPARATOR = "-";
    public static final String TIME_SEPARATOR = ":";
    public static final String CSV_SEPARATOR = ",";

    private final String filePath;

    public CsvParser(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Participant> findAll() {
        List<Participant> participantList = new ArrayList<>();
        List<String> fileEntries = extractContent(filePath);
        for(String entry : fileEntries) {
            participantList.add(convertToParticipant(entry));
        }
        return participantList;
    }

    private Participant convertToParticipant(String fileEntry) {
        String[] details = fileEntry.split(CSV_SEPARATOR);
        String lastName = details[0];
        String firstName = details[1];
        String checkin = details.length == 2 ? null : details[2];
        return new Participant(lastName, firstName, checkinToDateTime(checkin));
    }

    private LocalDateTime checkinToDateTime(String checkin) {
        String[] checkinDetails = checkin.split(DATE_TIME_SEPARATOR);
        String[] date = checkinDetails[0].split(DATE_SEPARATOR);
        String[] time = checkinDetails[1].split(TIME_SEPARATOR);
        LocalDate localDate = LocalDate.of(toInt(date[0]), toInt(date[1]), toInt(date[2]));
        LocalTime localTime = LocalTime.of(toInt(time[0]), toInt(time[1]));
        return LocalDateTime.of(localDate, localTime);

    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }

    private List<String> extractContent(String filePath) {

        List<String> content = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.replace("\"", ""));
            }
            content.remove(0);
        } catch (IOException e) {
            System.out.println("An error has occurred while extracting file content");
        }

        return content;
    }


}
