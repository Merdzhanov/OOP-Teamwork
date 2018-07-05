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
        //public void createNewMeeting(String name, String date, String startHour, String endHour, String description, String place) {
        public void createNewMeeting(){
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
            MeetingEvent meeting = new MeetingEvent(name, date, startHour, endHour, description, place);
            eventListForDay.add(meeting);
        }

        //public void createNewDeadline(String name, String date, String startHour, String endHour, String description) {
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
            DeadlineEvent deadline = new DeadlineEvent(name, date, startHour, endHour, description);
            eventListForDay.add(deadline);
        }

        //public void createNewVacation(String name, String date, String startHour, String endHour, String description, String place, VacationType vacationType) {
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
            VacationEvent vacation = new VacationEvent(name, date, startHour, endHour, description, place, VacationType.valueOf(vacationType));
            eventListForDay.add(vacation);
        }

        //public void createNewSportEvent(String name, String date, String startHour, String endHour, String description, String place, SportType typeOfSport, String firstCompetitor, String secondCompetitor) {
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
            SportEvent sport = new SportEvent(name, date, startHour, endHour, description, place, SportType.valueOf(typeOfSport), firstCompetitor, secondCompetitor);
            eventListForDay.add(sport);
        }

        //public void createNewBirthday(String name, String date, String startHour, String endHour, String description, String place, String nameOfBirthdayPerson, String gift) {
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
            BirthdayEvent birthday = new BirthdayEvent(name, date, startHour, endHour, description, place, nameOfBirthdayPerson, gift);
            eventListForDay.add(birthday);
        }

        public void displayAllEvents() {
            for (Event event : eventListForDay) {
                System.out.println("Event Name: " + event.getName());
                System.out.println("Event Date: " + event.getDate());
                System.out.println("Event Start Time: " + event.getStartHour());
                System.out.println("Event End Time: " + event.getEndHour());
                System.out.println("Event Description: " + event.getDescription());
                System.out.println();
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