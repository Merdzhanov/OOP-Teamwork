package theblackpanther;

import java.util.ArrayList;

public class MeetingEvent extends Event implements Editable, Deletable {
    private String place;
    private ArrayList<String> participants;

    public MeetingEvent(String name, String date, String startHour, String endHour, String description, String place) {
        super(name, date, startHour, endHour, description);
        setPlace(place);
        setParticipants();
    }

    @Override
    public void displayEvent() {
        System.out.printf("Event Name: %s\nEvent Date: %s\nEvent Start Time: %s\nEvent End Time: %s\nEvent Description: %s\nEvent Location: %s\n" +
                "Event Participants: %s\n", getName(), getDate(), getStartHour(), getEndHour(), getDescription(), getPlace(), getParticipants());
    }

    /*@Override
    public void deleteEvent() {

    }*/

    void addParticipant(String participant){
        participants.add(participant);
    }

    @Override
    public void edit(String name, String date, String startHour, String endHour, String description) {
        super.setName(name);
        super.setDate(date);
        super.setStartHour(startHour);
        super.setEndHour(endHour);
        super.setDescription(description);
    }

    @Override
    public void deleteEvent(Day ourDay, String nameOfEvent) {

    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public void setParticipants() {
        this.participants = new ArrayList<>();
    }
}
