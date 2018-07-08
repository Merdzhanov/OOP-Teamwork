package theblackpanther;

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
                        if(currentYear != 2020){
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
                        e.printStackTrace();
                       }
                    DateFormat format2 = new SimpleDateFormat("EEEE");
                    String finalDay = format2.format(dt1);

                    Day ourDay = new Day(finalDay,"" + currentDay);

                    ourCurrentMonth.addDayIntoMonth(ourDay);
                }
            }
        }
    }

    Day chooseDay() {
        Scanner in = new Scanner(System.in);
        System.out.print("Year: ");
        String year = in.nextLine();
        System.out.print("Month: ");
        String month = in.nextLine();
        System.out.print("Day: ");
        String dayString = in.nextLine();
        return findDay(dayString, month, year);
    }

    private Year chooseYear() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose Year:");
        String chosenYearNumber = in.nextLine();

        return findYear(chosenYearNumber);
    }

    private Year findYear(String year) {
        try {
            return returnYear(year);
        } catch (DateNotInCalendarException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Day findDay(String day, String month, String year) {
        try {
            Year yearInstance = returnYear(year);
            Month monthInstance = yearInstance.returnMonth(month);
            return monthInstance.returnDay(day);
        } catch (DateNotInCalendarException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Year returnYear(String yearNumber){

        for (Year currentYear : this.calendarYears) {
            if (currentYear.getYearNumber().equals(yearNumber)) {
                return currentYear;
            }
        }
        throw new DateNotInCalendarException("No such year in this calendar!" +
                "(please choose one of the following years (2018, 2019, 2020, 2021, 2022))"
                , WrongDateElementType.WRONG_YEAR);
    }

    void printCalendar(){
        for(int currentYear = 0; currentYear <= 4; currentYear++){
            System.out.println("-----------------------------------------");
            String yearNumber = calendarYears.get(currentYear).getYearNumber();
            System.out.println("YEAR : " + yearNumber);
            for(int currentMonth = 0 ; currentMonth <= 11; currentMonth++){
                MonthName monthName= calendarYears.get(currentYear).getCurrentMonth(currentMonth);
                System.out.println("MONTH : " + monthName);
                calendarYears.get(currentYear)
                        .getMonths()
                        .get(currentMonth)
                        .displayAllDays();
            }
        }
    }

    void printYear(){

        Year ourYear = chooseYear();
        String ourYearNumber = ourYear.getYearNumber();

        System.out.println("YEAR : " + ourYearNumber);

        for(int currentYear = 0; currentYear <= 4; currentYear++){
            String yearNumber = calendarYears.get(currentYear).getYearNumber();
            if(ourYearNumber.equals(yearNumber)){
                for(int currentMonth = 0 ; currentMonth <= 11; currentMonth++){
                    MonthName monthName = calendarYears.get(currentYear).getCurrentMonth(currentMonth);
                    System.out.println("MONTH : " + monthName);
                    calendarYears.get(currentYear)
                            .getMonths()
                            .get(currentMonth)
                            .displayAllDays();
                }
            }
        }
    }

    public void printMonth(){
        System.out.println("Choose Year:");

        String chosenYearNumber = input.nextLine();

        System.out.println("Choose Month:");

        String chosenMonth =  input.nextLine();

        for(int currentYear = 0; currentYear <= 4; currentYear++){
            String yearNumber = calendarYears.get(currentYear).getYearNumber();
            if(chosenYearNumber.equals(yearNumber)){
                for(int currentMonth = 0 ; currentMonth <= 11; currentMonth++){
                    MonthName monthName = calendarYears.get(currentYear).getCurrentMonth(currentMonth);
                    if(chosenMonth.equals(monthName.toString())) {
                        System.out.println("YEAR : " + chosenYearNumber);
                        System.out.println("MONTH : " + monthName);
                        calendarYears.get(currentYear)
                                .getMonths()
                                .get(currentMonth)
                                .displayAllDays();
                    }
                }
            }
        }
    }

    public void printAllDaysWithEventsInMonth(){
        System.out.println("Choose Year:");

        String chosenYearNumber = input.nextLine();

        System.out.println("Choose Month:");

        String chosenMonth =  input.nextLine();

        for(int currentYear = 0; currentYear <= 4; currentYear++){
            String yearNumber = calendarYears.get(currentYear).getYearNumber();
            if(chosenYearNumber.equals(yearNumber)){
                for(int currentMonth = 0 ; currentMonth <= 11; currentMonth++){
                    MonthName monthName = calendarYears.get(currentYear).getCurrentMonth(currentMonth);
                    if(chosenMonth.equals(monthName.toString())) {
                        System.out.println("YEAR : " + chosenYearNumber);
                        System.out.println("MONTH : " + monthName);
                        calendarYears.get(currentYear)
                                .getMonths()
                                .get(currentMonth)
                                .displayAllDaysWithEvents();
                    }
                }
            }
        }
    }

    public void printAllDaysWithNotesInDay(){
        System.out.println("Choose Year:");

        String chosenYearNumber = input.nextLine();

        System.out.println("Choose Month:");

        String chosenMonth =  input.nextLine();

        System.out.println("Choose Day:");

        String chosenDay =  input.nextLine();

        for(int currentYear = 0; currentYear <= 4; currentYear++){
            String yearNumber = calendarYears.get(currentYear).getYearNumber();
            if(chosenYearNumber.equals(yearNumber)){
                for(int currentMonth = 0 ; currentMonth <= 11; currentMonth++){
                    MonthName monthName = calendarYears.get(currentYear).getCurrentMonth(currentMonth);
                    if(chosenMonth.equals(monthName.toString())) {
                        System.out.println("YEAR : " + chosenYearNumber);
                        System.out.println("MONTH : " + monthName);
                        System.out.println("DAY : " + chosenDay);
                        calendarYears.get(currentYear)
                                .getMonths()
                                .get(currentMonth)
                                .returnDay(chosenDay)
                                .displayAllNotes();
                    }
                }
            }
        }
    }

}

