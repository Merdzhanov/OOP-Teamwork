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
                    System.out.print("Year: ");
                    String year = in.nextLine();
                    System.out.print("Month: ");
                    String month = in.nextLine();
                    System.out.print("Day: ");
                    String dayString = in.nextLine();
                    Day day = calendar.findDay(dayString, month, year);


                    System.out.print("Event type: ");
                    String eventType=in.nextLine();
                    switch(eventType) {
                        case "Meeting":
                            System.out.print("Event name: ");
                            String name = in.nextLine();
                            String date = dayString + "/" + month + "/" + year;
                            System.out.print("Start hour: ");
                            String startHour = in.nextLine();
                            System.out.print("End hour: ");
                            String endHour = in.nextLine();
                            System.out.print("Description: ");
                            String description = in.nextLine();
                            System.out.print("Place: ");
                            String place = in.nextLine();
                            MeetingEvent newMeeting=new MeetingEvent(name,date, startHour, endHour, description, place);
                            day.addEvent(newMeeting);
                            break;
                    }break;
                case "2":{
                    System.out.print("Year: ");
                    year = in.nextLine();
                    System.out.print("Month: ");
                    month = in.nextLine();
                    System.out.print("Day: ");
                    dayString = in.nextLine();
                    day = calendar.findDay(dayString, month, year);
                    day.displayAllEvents();
                    break;
                }
                case "3":
                    System.out.print("Year: ");
                    year = in.nextLine();
                    System.out.print("Month: ");
                    month = in.nextLine();
                    System.out.print("Day: ");
                    dayString = in.nextLine();
                    day = calendar.findDay(dayString, month, year);
                    System.out.print("Event Name: ");
                    String  eventName=in.nextLine();
                    Event event= day.selectEvent(eventName);
                    day.removeEvent(event);
                    break;
            }
        }
    }
}