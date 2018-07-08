package theblackpanther;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Month {
    private MonthName name;
    private ArrayList<Day> days;
    private ArrayList<Day> eventDays;


    Month(MonthName name) {
        setName(name);
        setDays(new ArrayList<Day>());
        setEventDays(new ArrayList<Day>());
    }

    void addDayIntoMonth(Day newDay){
        days.add(newDay);
    }

    void displayAllDays(){

        int daysSize = days.size();

        days.stream()
                .limit(7)
                .forEach(day -> System.out.printf("%3s", day.getDate() + " "));
        System.out.println();

        days.subList(7, 14)
                .stream()
                .limit(7)
                .forEach(day -> System.out.printf("%3s", day.getDate() + " "));
        System.out.println();

        days.subList(14, 21)
                .stream()
                .limit(7)
                .forEach(day -> System.out.printf("%3s", day.getDate() + " "));
        System.out.println();

        days.subList(21, 28)
                .stream()
                .limit(7)
                .forEach(day -> System.out.printf("%3s", day.getDate() + " "));
        System.out.println();

        days.subList(28, daysSize)
                .stream()
                .limit(7)
                .forEach(day -> System.out.printf("%3s", day.getDate() + " "));
        System.out.println();

    }

    private boolean isThereEvent(Day currentDay){
        return currentDay.getEventListForDay().size() != 0;
    }

    void displayAllDaysWithEvents(){
        List<Day> filtered = days.stream().filter(this::isThereEvent).collect(Collectors.toList());
        eventDays.addAll(filtered);

        for (Day eventDay : eventDays) {
            System.out.println(eventDay.getDayOfWeek() + "/DAY: " + eventDay.getDate() + ":");
            for (int currentEvent = 0; currentEvent < eventDay.getEventListForDay().size(); currentEvent++) {
                System.out.println("Description of the event :\n" +
                        eventDay
                                .getEventListForDay()
                                .get(currentEvent)
                                .getDescription());
            }
        }
    }

    public MonthName getName() {
        return name;
    }

    public void setName(MonthName name) {
        this.name = name;
    }

    private void setDays(ArrayList<Day> days) {
        this.days = days;
    }

    private void setEventDays(ArrayList<Day> eventDays) {
        this.eventDays = eventDays;
    }

    Day returnDay(String dayNumber) {
        for (Day dayInstance : this.days) {
            if (dayInstance.getDate().equals(dayNumber)) {
                return dayInstance;
            }
        }

        throw new DateNotInCalendarException("No such day in this calendar! " +
                "(please type in the right format: example \"1\")", WrongDateElementType.WRONG_DAY);
    }
}
