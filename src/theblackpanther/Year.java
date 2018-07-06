package theblackpanther;

import java.util.ArrayList;

public class Year {
    private String yearNumber;
    private ArrayList<Month> months;

    public Year(String yearNumber) {
        setYearNumber(yearNumber);
        setMonths(new ArrayList<Month>());
    }

    public void addMonthIntoYear (Month newMonth){
        months.add(newMonth);
    }

    public void displayAllMonths(){

        int monthsSize = months.size();

        months.stream().limit(6).forEach(month -> System.out.printf("%10s", month + " "));
        System.out.println();
        months.subList(6, monthsSize).stream().forEach(month -> System.out.printf("%10s", month + " "));
        System.out.println();


   /*     int monthCounter = 0;
        Month currentMonth;
        for(int i = 0; i < months.size(); i++){
            currentMonth = months.get(i);
            if(monthCounter < 6){
                System.out.print(currentMonth + " ");
            }else{
                monthCounter = 0;
                System.out.println();
            }
        } */
    }

    public MonthName getCurrentMonth(int choosenMonth){
        for(int i = 0; i < months.size(); i++){
            if(choosenMonth == i){
                return months.get(i).getName();
            }
        }
        return null;
    }

    public String getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(String yearNumber) {
        this.yearNumber = yearNumber;
    }

    public ArrayList<Month> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<Month> months) {
        this.months = months;
    }

    public Month returnMonth(String monthName) {
        for (Month monthInstance : this.months) {
            if (monthInstance.getName().name().equals(monthName)) {
                return monthInstance;
            }
        }
        System.out.println("Wrong month name!");
        return null;
    }
}
