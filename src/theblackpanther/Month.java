package theblackpanther;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Month {
    private MonthName name;
    private ArrayList<Day> days;
    private ArrayList<Day> eventDays;
    private int numberOfDays;


    public Month(MonthName name, int numberOfDays) {
        setName(name);
        setDays(new ArrayList<Day>());
        setEventDays(new ArrayList<Day>());
        setNumberOfDays(numberOfDays);
    }


    public boolean isThereEvent(Day currentDay){
        if(currentDay.getEventListForDay().size() != 0){
            return true;
        }
        return false;
    }

    public void addDayIntoMonth(Day newDay){
        days.add(newDay);
    }

    public void displayAllDays(){

        long daysSize = days.stream().count();

        List<Day> filtered = days.stream().filter(this::isThereEvent).collect(Collectors.toList());
        eventDays.addAll(filtered);

        days.stream().limit(7).forEach(day -> System.out.printf("%3s", day + " "));
        System.out.println();
        days.subList(7, 14).stream().limit(7).forEach(day -> System.out.printf("%3s", day + " "));
        System.out.println();
        days.subList(14, 21).stream().limit(7).forEach(day -> System.out.printf("%3s", day + " "));
        System.out.println();
        days.subList(21, 28).stream().limit(7).forEach(day -> System.out.printf("%3s", day + " "));
        System.out.println();
        days.subList(28, (int)daysSize - 1).stream().limit(7).forEach(day -> System.out.printf("%3s", day + " "));
        System.out.println();


    /*    int counter = 0;
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
        } */
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

    public Day returnDay(String dayNumber) {
        for (Day dayInstance : this.days) {
            if (dayInstance.getDate().equals(dayNumber)) {
                return dayInstance;
            }
        }
        //exception
        System.out.println("No such day in this month!");
        return null;
    }
}
