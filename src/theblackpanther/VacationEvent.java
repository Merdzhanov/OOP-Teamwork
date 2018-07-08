package theblackpanther;

import java.util.ArrayList;
import java.util.List;

public class VacationEvent extends Event implements Deletable {
    private String place;
    private List<String> participants;
    private VacationType vacationType;

    VacationEvent(String name, String date, String startHour, String endHour, String description, String place, VacationType vacationType) {
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
    public void deleteEvent(Day ourDay, String nameOfEvent) {

    }

    private String getPlace() {
        return place;
    }

    private List<String> getParticipants() {
        return participants;
    }

    private VacationType getVacationType() {
        return vacationType;
    }

    private void setPlace(String place) {
        this.place = place;
    }

    private void setParticipants() {
        this.participants = new ArrayList<>();
    }

    private void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

}
