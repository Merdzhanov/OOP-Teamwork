import jdk.jfr.Event;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Day {
    private DayOfWeek dayOfWeek;
    private String date;
    private List<Event> eventListForDay;

//Constructor
    public Day(DayOfWeek dayOfWeek, int date) {
        setDayOfWeek(dayOfWeek);
        setDate(date);
        setEventListForDay();
    }

//Getters
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDate() {
        return date;
    }

    public List<Event> getEventListForDay() {
        return eventListForDay;
    }


//Setters
    private void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    private void setDate(String date) {
        this.date = date;
    }

    private void setEventListForDay() {
        this.eventListForDay = new ArrayList<>();
    }

//Methods
    public void createNewEvent(String name, String date, String startHour, String endHour, String description) {
        Event newEvent = new Event(name, date, startHour, endHour, description);

    }
}
