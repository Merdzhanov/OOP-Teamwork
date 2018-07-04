package theblackpanther;

import java.util.ArrayList;

public class Meeting extends Event implements Editable, Deletable {
    String place;
    ArrayList<String> participants;

    @Override
    public void displayEvent() {

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
