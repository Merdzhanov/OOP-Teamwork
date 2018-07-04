package theblackpanther;

import java.util.ArrayList;
import java.util.List;

public class VacationEvent extends Event implements Deletable {
    private String place;
    private List<String> participants;
    private VacationType vacationType;

    public VacationEvent(String name, String date, String startHour, String endHour, String description, String place, VacationType vacationType) {
        super(name, date, startHour, endHour, description);
        setPlace(place);
        setParticipants();
        setVacationType(vacationType);
    }

    @Override
    public void displayEvent() {
        System.out.printf("Event Name: %s\nEvent Date: %s\nEvent Start Time: %s\nEvent End Time: %s\nEvent Description: %s\nEvent Location: %s\n" +
                "Event Participants: %s\nEvent Type: %s\n", getName(), getDate(), getStartHour(), getEndHour(),
                getDescription(), getPlace(), getParticipants(), getVacationType());
    }

    @Override
    public void deleteEvent(Day day, Event ourEvent) {

    }

    void addParticipant(String participant){
        participants.add(participant);
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants() {
        this.participants = new ArrayList<>();
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

}
