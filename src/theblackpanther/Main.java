package theblackpanther;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        CalendarApp calendar = new CalendarApp();
        System.out.println();
        String command="Menu";

        while(!command.equals("0")){
            System.out.println("Select activity:");
            System.out.println("1 - Add event");
            System.out.println("2 - Display events per day");
            System.out.println("3 - Delete event");
            System.out.println("0 - Exit");
            command = in.nextLine();
            switch(command){
                case "0": break;
                case "1":
                    Day day=calendar.chooseDay();
                    System.out.print("Event type: ");
                    String eventType=in.nextLine();
                    switch(eventType) {
                        case "Meeting Event":
                            day.createNewMeeting();
                            break;
                        case "Sport Event":
                            day.createNewSportEvent();
                            break;
                        case "Birthday Event":
                            day.createNewBirthdayEvent();
                            break;
                        case "Deadline Event":
                            day.createNewDeadlineEvent();
                            break;
                        case "Vacation Event":
                            day.createNewVacationEvent();
                            break;
                    }break;
                case "2":{
                    day=calendar.chooseDay();
                    day.displayAllEvents();
                    break;
                }
                case "3":
                    day=calendar.chooseDay();
                    System.out.print("Event Name: ");
                    String  eventName=in.nextLine();
                    Event event= day.selectEvent(eventName);
                    //day.removeEvent(event);
                    break;
            }
        }
    }
}
