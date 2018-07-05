package theblackpanther;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day {
        private String dayOfWeek;
        private String date;
        private List<Event> eventListForDay;
        private ArrayList<Note> notes;

        //Constructor
        public Day(String dayOfWeek, String date) {
            setDayOfWeek(dayOfWeek);
            setDate(date);
            setEventListForDay();
            setNotes(new ArrayList<>());
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

        public ArrayList<Note> getNotes() {
            return notes;
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

        public void setNotes(ArrayList<Note> notes) {
            this.notes = notes;
        }

        //Methods
        //public void createNewMeeting(String name, String date, String startHour, String endHour, String description) {
        public void createNewMeeting(){
            // add here: Meeting newMeeting = new Meeting(parameters);
            // eventListForDay.add(newMeeting);
            // the same for every type of event
            Scanner in=new Scanner(System.in);
            System.out.print("Event name: ");
            String name = in.nextLine();
            System.out.print("Start hour: ");
            String startHour = in.nextLine();
            System.out.print("End hour: ");
            String endHour = in.nextLine();
            System.out.print("Description: ");
            String description = in.nextLine();
            System.out.print("Place: ");
            String place = in.nextLine();
            MeetingEvent newMeeting = new MeetingEvent(name, this.getDate(), startHour, endHour, description, place);
            this.addEvent(newMeeting);
        }
    public void createNewSportEvent(){
        Scanner in=new Scanner(System.in);
        System.out.print("Event name: ");
        String name = in.nextLine();
        System.out.print("Start hour: ");
        String startHour = in.nextLine();
        System.out.print("End hour: ");
        String endHour = in.nextLine();
        System.out.print("Description: ");
        String description = in.nextLine();
        System.out.print("Place: ");
        String place = in.nextLine();
        System.out.print("Type of sport: ");
        String typeOfSport=in.nextLine();
        System.out.print("First Competitor: ");
        String firstCompetitor = in.nextLine();
        System.out.print("Second Competitor: ");
        String secondCompetitor = in.nextLine();
        SportEvent sportEvent = new SportEvent(name, date, startHour, endHour, description, place,SportType.valueOf(typeOfSport),firstCompetitor,secondCompetitor);
        this.addEvent(sportEvent);
    }
    public void createNewDeadlineEvent(){
        Scanner in=new Scanner(System.in);
        System.out.print("Event name: ");
        String name = in.nextLine();
        System.out.print("Start hour: ");
        String startHour = in.nextLine();
        System.out.print("End hour: ");
        String endHour = in.nextLine();
        System.out.print("Description: ");
        String description = in.nextLine();
        DeadlineEvent deadlineEvent = new DeadlineEvent(name, this.getDate(), startHour, endHour, description);
        this.addEvent(deadlineEvent);
    }
    public void createNewBirthdayEvent(){
        Scanner in=new Scanner(System.in);
        System.out.print("Event name: ");
        String name = in.nextLine();
        System.out.print("Start hour: ");
        String startHour = in.nextLine();
        System.out.print("End hour: ");
        String endHour = in.nextLine();
        System.out.print("Description: ");
        String description = in.nextLine();
        System.out.print("Place: ");
        String place = in.nextLine();
        System.out.print("Who has a birthday: ");
        String nameOfBirthdayPerson = in.nextLine();
        System.out.print("Gift: ");
        String gift = in.nextLine();
        BirhtdayEvent birthdayEvent = new BirhtdayEvent(name, this.getDate(), startHour, endHour, description, place, nameOfBirthdayPerson, gift);
        this.addEvent(birthdayEvent);
    }
    public void createNewVacationEvent(){
        Scanner in=new Scanner(System.in);
        System.out.print("Event name: ");
        String name = in.nextLine();
        System.out.print("Start hour: ");
        String startHour = in.nextLine();
        System.out.print("End hour: ");
        String endHour = in.nextLine();
        System.out.print("Description: ");
        String description = in.nextLine();
        System.out.print("Place: ");
        String place = in.nextLine();
        System.out.print("Vacation Type: ");
        String vacationType = in.nextLine();
        VacationEvent vacationEvent = new VacationEvent(name, this.getDate(), startHour, endHour, description, place, VacationType.valueOf(vacationType));
        this.addEvent(vacationEvent);
    }

        public void addEvent(Event event) {
            eventListForDay.add(event);
        }
        public void removeEvent(Event event) {
            eventListForDay.remove(event);
        }

        public void displayAllEvents() {
            for (Event event : eventListForDay) {
                event.displayEvent();
               // System.out.println(event);                   // need to Override toString
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

        public void createNote(String noteContent){
            Note newNote = new Note(noteContent);
            notes.add(newNote);
        }
    }