package theblackpanther;

import java.util.ArrayList;

public class Meeting extends Event implements Editable, Deletable {
    String place;
    ArrayList<String> participants;

    public Meeting(String name, String date, String startHour, String endHour, String description, String place) {
        super(name, date, startHour, endHour, description);
        this.place = place;
        this.participants = new ArrayList<String>();
    }

    @Override
    public void displayEvent() {

    }

    @Override
    public void deleteEvent() {

    }
/*@Override
    public void deleteEvent() {

    }*/

    void addParticipant(String participant){

    }

    @Override
    public void edit(String name, String date, String startHour, String endHour, String description) {

    }

    @Override
    public void delete() {

    }
}
