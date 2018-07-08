package theblackpanther;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class CalendarApp {
    private ArrayList<Year> calendarYears;

    CalendarApp() {
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
                Month ourCurrentMonth = new Month(ourMonth);

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

    private Day findDay(String day, Month ourMonth) {
        try {
            return ourMonth.returnDay(day);
        } catch (DateNotInCalendarException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Day chooseDay(Month ourMonth) {

        Scanner in = new Scanner(System.in);

        System.out.print("Choose Day: ");
        String dayString = in.nextLine();

        return findDay(dayString, ourMonth);
    }


    private Month findMonth(String month, Year year) {

        try {
            return year.returnMonth(month);
        } catch (DateNotInCalendarException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Month chooseMonth(Year year){
        Scanner in = new Scanner(System.in);
        System.out.print("Choose Month: ");
        String month = in.nextLine();

        return findMonth(month, year);
    }


    private Year findYear(String year) {
        try {
            return returnYear(year);
        } catch (DateNotInCalendarException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Year chooseYear() {
        Scanner in = new Scanner(System.in);
        System.out.print("Choose Year: ");
        String chosenYearNumber = in.nextLine();

        return findYear(chosenYearNumber);
    }

    Day selectDate(){

        Year ourYear = chooseYear();
        Month ourMonth = chooseMonth(ourYear);
        Day ourDay = chooseDay(ourMonth);

        return ourDay;
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

        for(Year ourYear : calendarYears){
            System.out.println("---------------------------------------\n");
            System.out.println("YEAR : " + ourYear.getYearNumber());
            ourYear.displayAllMonths();
        }

    }

    void printYear(){

        Year ourYear = chooseYear();
        String ourYearNumber = ourYear.getYearNumber();

        System.out.println("YEAR : " + ourYearNumber);

        ourYear.displayAllMonths();
    }

    void printMonth(){

        Year ourYear = chooseYear();
        Month ourMonth = chooseMonth(ourYear);

        System.out.println("YEAR : " + ourYear.getYearNumber());
        System.out.println("MONTH : " + ourMonth.getName());

        ourMonth.displayAllDays();

    }


    void printAllDaysWithNotesInDay(){

        Year ourYear = chooseYear();
        Month ourMonth = chooseMonth(ourYear);
        Day ourDay = chooseDay(ourMonth);

        System.out.println("---------------------------------------\n");
        System.out.println("YEAR : " + ourYear.getYearNumber());
        System.out.println("MONTH : " + ourMonth.getName());
        System.out.println("DAY : " + ourDay.getDate());

        ourDay.displayAllNotes();
    }

    void printAllDaysWithEventsInMonth(){

        Year ourYear = chooseYear();
        Month ourMonth = chooseMonth(ourYear);

        System.out.println("YEAR : " + ourYear.getYearNumber());
        System.out.println("MONTH : " + ourMonth.getName());

        ourMonth.displayAllDaysWithEvents();

    }


}

