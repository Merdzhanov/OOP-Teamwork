import java.util.ArrayList;

public class Month {
    private String name;
    private ArrayList<Day> days;
    private ArrayList<Day> eventDays;

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
}
