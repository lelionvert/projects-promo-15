package entities;

import java.time.LocalDateTime;

public class Participant {

    private final String lastName;
    private final String firstName;
    private final LocalDateTime checkin;


    public Participant(String lastName, String firstName, LocalDateTime checkin) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.checkin = checkin;
    }

    public boolean hasCheckin() {
        return checkin != null;
    }

    public boolean isCheckinBefore(int hour) {
        return checkin.getHour() < hour;
    }
}
