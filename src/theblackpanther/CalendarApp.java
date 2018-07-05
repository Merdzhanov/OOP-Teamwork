package theblackpanther;

import theblackpanther.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CalendarApp {
    private ArrayList<Year> calendarYears;

    public CalendarApp() {
        this.calendarYears = new ArrayList<>();

        for(int currentYear = 2018; currentYear <= 2022; currentYear++){
            Year ourYear = new Year("" + currentYear);

            calendarYears.add(ourYear);

            for (MonthName ourMonth : MonthName.values()) {
                int numberOfDays = 0;
                int ourMonthNumber = 0;
                switch (ourMonth){
                    case JANUARY :
                        numberOfDays = 31;
                        ourMonthNumber = 1;
                        break;
                    case FEBRUARY:
                        if(currentYear != 2){
                            numberOfDays = 28;
                        }else{
                            numberOfDays = 29;
                        }ourMonthNumber = 2; break;
                    case MARCH:
                        numberOfDays = 31;
                        ourMonthNumber = 3;
                        break;
                    case APRIL:
                        numberOfDays = 30;
                        ourMonthNumber = 4;
                        break;
                    case MAY:
                        numberOfDays = 31;
                        ourMonthNumber = 5;
                        break;
                    case JUNE:
                        numberOfDays = 30;
                        ourMonthNumber = 6;
                        break;
                    case JULY:
                        numberOfDays = 31;
                        ourMonthNumber = 7;
                        break;
                    case AUGUST:
                        numberOfDays = 31;
                        ourMonthNumber = 8;
                        break;
                    case SEPTEMBER:
                        numberOfDays = 30;
                        ourMonthNumber = 9;
                        break;
                    case OCTOBER:
                        numberOfDays = 31;
                        ourMonthNumber = 10;
                        break;
                    case NOVEMBER:
                        numberOfDays = 30;
                        ourMonthNumber = 11;
                        break;
                    case DECEMBER:
                        numberOfDays = 31;
                        ourMonthNumber = 12;
                        break;
                }
                Month ourCurrentMonth = new Month(ourMonth, numberOfDays);

                ourYear.addMonthIntoYear(ourCurrentMonth);

                for(int currentDay = 1; currentDay <= numberOfDays; currentDay++){
                    //calculating week day
                    String date = "" + currentDay + "/" + ourMonthNumber + "/" + currentYear;
                    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                    Date dt1 = new Date();
                    try {
                        dt1=format1.parse(date);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    DateFormat format2 = new SimpleDateFormat("EEEE");
                    String finalDay = format2.format(dt1);

                    Day ourDay = new Day(finalDay,"" + currentDay);

                    ourCurrentMonth.addDayIntoMonth(ourDay);
                }
            }
        }
    }

    public Year returnYear(String yearNumber) {
        for (Year currentYear : this.calendarYears) {
            if (currentYear.getYearNumber().equals(yearNumber)) {
                return currentYear;
            }
        }
//        public void wrapException(String input) throws MyBusinessException {
//            try {
//                // do something
//            } catch (NumberFormatException e) {
//                throw new MyBusinessException("A message that describes the error.", e, ErrorCode.INVALID_PORT_CONFIGURATION);
//            }
//        }
        System.out.println("No such year in this calendar!");
        return null;
    }

    public Day chooseDay() {
        Scanner in=new Scanner(System.in);
        //System.out.print("Event name: ");
        System.out.print("Year: ");
        String year = in.nextLine();
        System.out.print("Month: ");
        String month = in.nextLine();
        System.out.print("Day: ");
        String dayString = in.nextLine();
        Day day = this.findDay(dayString, month, year);
        return day;

    }

    public Day findDay(String day, String month, String year) {
            Year yearInstance = returnYear(year);
            Month monthInstance = yearInstance.returnMonth(month);
            Day dayInstance = monthInstance.returnDay(day);
            return dayInstance;

        }
    }

