package theblackpanther;

import java.util.ArrayList;

public class Month {
    private MonthName name;
    private ArrayList<Day> days;
    private ArrayList<Day> eventDays;
    private int numberOfDays;

    public Month(MonthName name, int numberOfDays) {
        this.name = name;
        this.days = new ArrayList<Day>();
        this.eventDays = new ArrayList<Day>();
        this.numberOfDays = numberOfDays;
    }


    public boolean isThereEvent(Day currentDay){
        if(currentDay.getEventListForDay().size() != 0){
            return true;
        }
        return false;
    }

    public void displayAllDays(){
        int counter = 0;
        Day currentDay;
        for(int i = 0; i < days.size(); i++){
            currentDay = days.get(i);
            if(isThereEvent(currentDay)){
                eventDays.add(currentDay);
            }
            if(counter < 7) {
                System.out.print(days.get(i) + " ");
                counter++;
            }else{
                System.out.println();
                counter = 0;
            }
        }
    }

    public void displayAllDaysWithEvents(){
        for(int i = 0; i < eventDays.size(); i++) {
            System.out.println(eventDays.get(i) + " ");
        }
    }

    public MonthName getName() {
        return name;
    }

    public void setName(MonthName name) {
        this.name = name;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }

    public ArrayList<Day> getEventDays() {
        return eventDays;
    }

    public void setEventDays(ArrayList<Day> eventDays) {
        this.eventDays = eventDays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}