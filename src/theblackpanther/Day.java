package theblackpanther;

import java.util.ArrayList;
import java.util.List;

    public class Day {
        private String dayOfWeek;
        private String date;
        private List<Event> eventListForDay;

        //Constructor
        public Day(String dayOfWeek, String date) {
            setDayOfWeek(dayOfWeek);
            setDate(date);
            setEventListForDay();
        }

        //Getters
        public String getDayOfWeek() {
            return dayOfWeek;
        }

        public String getDate() {
            return date;
        }

        public List<Event> getEventListForDay() {
            return eventListForDay;
        }


        //Setters
        private void setDayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        private void setDate(String date) {
            this.date = date;
        }

        private void setEventListForDay() {
            this.eventListForDay = new ArrayList<>();
        }

        //Methods
        public void createNewMeeting(String name, String date, String startHour, String endHour, String description) {
            // add here: Meeting newMeeting = new Meeting(parameters);
            // eventListForDay.add(newMeeting);
            // the same for every type of event
        }

        public void displayAllEvents() {
            for (Event event : eventListForDay) {
                System.out.println(event);                   // need to Override toString
            }
        }

        public Event selectEvent(String eventName) {
            for (Event event : eventListForDay) {
                if (eventName.equals(event.getName())) {
                    return event;
                }
            }
            return null;
        }
    }