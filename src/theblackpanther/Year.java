package theblackpanther;

import java.util.ArrayList;

public class Year {
    private YearNumber yearNumber;
    private ArrayList<Month> months;

    public Year(YearNumber yearNumber) {
        this.yearNumber = yearNumber;
        this.months = new ArrayList<Month>();
    }

    public void displayAllMonths(){
        int monthCounter = 0;
        Month currentMonth;
        for(int i = 0; i < months.size(); i++){
            currentMonth = months.get(i);
            if(monthCounter < 6){
                System.out.print(currentMonth + " ");
            }else{
                monthCounter = 0;
                System.out.println();
            }
        }
    }

    public YearNumber getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(YearNumber yearNumber) {
        this.yearNumber = yearNumber;
    }

    public ArrayList<Month> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<Month> months) {
        this.months = months;
    }
}
