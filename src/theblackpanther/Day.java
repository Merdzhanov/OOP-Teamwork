package theblackpanther;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day {
    private String dayOfWeek;
    private String date;
    private List<Event> eventListForDay;
    private List<Editable> editableEventListForDay;
    private List<Deletable> deletableEventListForDay;
    private ArrayList<Note> notes;

    //Constructor
    Day(String dayOfWeek, String date) {
        setDayOfWeek(dayOfWeek);
        setDate(date);
        setEventListForDay();
        setEditableEventListForDay();
        setDeletableEventListForDay();
        setNotes();
    }

    void createNewMeeting() {
        Scanner in = new Scanner(System.in);
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
        editableEventListForDay.add(meeting);
        deletableEventListForDay.add(meeting);
    }

    void createNewDeadlineEvent() {
        Scanner in = new Scanner(System.in);
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
        editableEventListForDay.add(deadline);
    }

    void createNewVacationEvent() {
        Scanner in = new Scanner(System.in);
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
        System.out.println("Choose one of the following: " +
                "SUMMER_HOLIDAY / " +
                "SKI_TRIP / " +
                "COUNTRYSIDE / " +
                "FAMILY_HOLIDAY / " +
                "LADS_ON_TOUR");
        System.out.print("Vacation Type: ");
        String vacationType = in.nextLine();
        VacationEvent vacation = new VacationEvent(name, date, startHour, endHour, description, place, VacationType.valueOf(vacationType));
        eventListForDay.add(vacation);
        deletableEventListForDay.add(vacation);
    }

    void createNewSportEvent() {
        Scanner in = new Scanner(System.in);
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
        System.out.println("Choose one of the following: " +
                "VOLLEYBALL / " +
                "BASKETBALL / " +
                "BOXING / " +
                "TENNIS / " +
                "RUNNING");
        System.out.print("Type of sport: ");
        String typeOfSport = in.nextLine();
        System.out.print("First Competitor: ");
        String firstCompetitor = in.nextLine();
        System.out.print("Second Competitor: ");
        String secondCompetitor = in.nextLine();
        SportEvent sport = new SportEvent(name, date, startHour, endHour, description, place, SportType.valueOf(typeOfSport), firstCompetitor, secondCompetitor);
        eventListForDay.add(sport);
        deletableEventListForDay.add(sport);
    }

    void createNewBirthdayEvent() {
        Scanner in = new Scanner(System.in);
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

    void createNote() {
        Scanner in = new Scanner(System.in);
        System.out.print("Type your text: ");
        String noteContent = in.nextLine();
        Note newNote = new Note(noteContent);
        notes.add(newNote);
    }

    private Editable selectEditableEvent(String eventName) {
        for (Editable event : editableEventListForDay) {
            Event castedAsEvent = (Event) event;
            if (eventName.equals(castedAsEvent.getName())) {
                return event;
            }
        }
        return null;
    }

    private Deletable selectDeletableEvent(String eventName) {
        for (Deletable event : deletableEventListForDay) {
            Event castedAsEvent = (Event) event;
            if (eventName.equals(castedAsEvent.getName())) {
                return event;
            }
        }
        return null;
    }

    void displayAllEvents() {
        for (Event event : eventListForDay) {
            System.out.println("---------------------------------------------\n");
            System.out.println("Event Name: " + event.getName());
            System.out.println("Event Date: " + event.getDate());
            System.out.println("Event Start Time: " + event.getStartHour());
            System.out.println("Event End Time: " + event.getEndHour());
            System.out.println("Event Description: " + event.getDescription());
            System.out.println();
        }
    }

    void displayAllNotes(){
        this.getNotes()
                .stream()
                .forEach(ourNote -> System.out.println("NOTE: " + ourNote.getNoteContent()));
    }

    void deleteEvent() {
        Scanner in = new Scanner(System.in);
        System.out.print("Event Name: ");
        String eventName = in.nextLine();
        Deletable deletableEvent = selectDeletableEvent(eventName);
        if(deletableEvent != null){
            eventListForDay.remove(deletableEvent);

            deletableEventListForDay.remove(deletableEvent);

            if (editableEventListForDay.contains(deletableEvent)) {
                editableEventListForDay.remove(deletableEvent);
            }
        deletableEvent.deleteEvent(this, eventName);
        }else{
            System.out.println("CANNOT BE DELETED!!!");
        }
    }

    void editEvent() {
        Scanner in = new Scanner(System.in);
        System.out.print("Event Name: ");
        String eventName = in.nextLine();
        Editable editableEvent = selectEditableEvent(eventName);
        System.out.print("Start hour: ");
        String startHour = in.nextLine();
        System.out.print("End hour: ");
        String endHour = in.nextLine();

        if (editableEvent instanceof DeadlineEvent) {
            System.out.print("Description: ");
        } else {
            System.out.println("Place: ");
        }

        String descriptionOrPlace = in.nextLine();
        editableEvent.edit(eventName, this.getDate(), startHour, endHour, descriptionOrPlace);
    }

    Event selectEvent(String eventName) {
        for (Event event : eventListForDay) {
            if (eventName.equals(event.getName())) {
                return event;
            }
        }
        return null;
    }

    //Getters
    String getDayOfWeek() {
        return dayOfWeek;
    }

    List<Event> getEventListForDay() {
        return eventListForDay;
    }

    public String getDate() {
        return date;
    }

    private ArrayList<Note> getNotes() {
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

    private void setNotes() {
        this.notes = new ArrayList<>();
    }

    private void setEditableEventListForDay() {
        this.editableEventListForDay = new ArrayList<>();
    }

    private void setDeletableEventListForDay() {
        this.deletableEventListForDay = new ArrayList<>();
    }
}