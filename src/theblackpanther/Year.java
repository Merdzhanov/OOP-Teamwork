package theblackpanther;

import java.util.ArrayList;

class Year {
    private String yearNumber;
    private ArrayList<Month> months;

    Year(String yearNumber) {
        setYearNumber(yearNumber);
        setMonths(new ArrayList<Month>());
    }

    void addMonthIntoYear(Month newMonth){
        months.add(newMonth);
    }

    void displayAllMonths(){

        for( Month month : months) {
            System.out.println( month.getName());
            month.displayAllDays();
            }
        System.out.println();
    }

    Month returnMonth(String monthName) {
        for (Month monthInstance : this.months) {
            if (monthInstance.getName().name().equals(monthName)) {
                return monthInstance;
            }
        }
            throw new DateNotInCalendarException("No such month in this calendar! " +
                    "(please type in the right format: example \"JANUARY\")", WrongDateElementType.WRONG_MONTH);
    }

    String getYearNumber() {
        return yearNumber;
    }

    private void setYearNumber(String yearNumber) {
        this.yearNumber = yearNumber;
    }

    private void setMonths(ArrayList<Month> months) {
        this.months = months;
    }
}
