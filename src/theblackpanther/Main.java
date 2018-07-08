package theblackpanther;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CalendarApp calendar = new CalendarApp();
        System.out.println();
        String command="Menu";

        while(!command.equals("0")){
            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println();
            System.out.println("Select activity:");
            System.out.println("1 - Add event");
            System.out.println("2 - Add note");
            System.out.println("3 - Display events per day");
            System.out.println("4 - Display event");
            System.out.println("5 - Delete event");
            System.out.println("6 - Edit event");
            System.out.println("7 - View calendar");
            System.out.println("8 - View year by choice");
            System.out.println("9 - View month by choice");
            System.out.println("10 - View notes in a day by choice");
            System.out.println("11 - View events in a month by choice");
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
                    day.createNote();
                    break;
                }
                case "3":{
                    day=calendar.chooseDay();
                    day.displayAllEvents();
                    break;
                }
                case "4":
                    day=calendar.chooseDay();
                    System.out.print("Event Name: ");
                    String eventName = in.nextLine();
                    Event event = day.selectEvent(eventName);
                    event.displayEvent();
                    break;
                case "5":
                    day=calendar.chooseDay();
                    day.deleteEvent();
                    break;
                case "6":
                    day=calendar.chooseDay();
                    day.editEvent();
                    break;
                case "7":
                    calendar.printCalendar();
                    break;
                case "8":
                    calendar.printYear();
                    break;
                case "9":
                    calendar.printMonth();
                    break;
                case "10":
                    calendar.printAllDaysWithNotesInDay();
                    break;
                case "11":
                    calendar.printAllDaysWithEventsInMonth();
                    break;
            }
        }
    }
}
