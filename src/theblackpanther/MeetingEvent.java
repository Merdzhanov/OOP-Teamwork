package theblackpanther;

import java.util.ArrayList;
import java.util.Scanner;

public class MeetingEvent extends Event implements Editable, Deletable {
    private String place;
    private ArrayList<String> participants;

    MeetingEvent(String name, String date, String startHour, String endHour, String description, String place) {
        super(name, date, startHour, endHour, description);
        setPlace(place);
        setParticipants();
    }

    @Override
    public void displayEvent() {
        System.out.printf("Event Name: %s\nEvent Date: %s\nEvent Start Time: %s\nEvent End Time: %s\nEvent Description: %s\nEvent Location: %s\n" +
                "Event Participants: %s\n", getName(), getDate(), getStartHour(), getEndHour(), getDescription(), getPlace(), getParticipants());
    }

    @Override
    public void edit(String name, String date, String startHour, String endHour, String place) {
        super.setName(name);
        super.setDate(date);
        super.setStartHour(startHour);
        super.setEndHour(endHour);
        setPlace(place);
    }

    @Override
    public void deleteEvent(Day ourDay, String nameOfEvent) {

    }

    private String getPlace() {
        return place;
    }

    private ArrayList<String> getParticipants() {
        return participants;
    }

    private void setPlace(String place) {
        this.place = place;
    }

    private void setParticipants() {
        this.participants = new ArrayList<>();
    }
}
