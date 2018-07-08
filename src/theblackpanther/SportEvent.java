package theblackpanther;

public class SportEvent extends Event implements Deletable{

    private String place;
    private SportType typeOfSport;
    private String firstCompetitor;
    private String secondCompetitor;

    SportEvent(String name, String date, String startHour, String endHour, String description, String place,
               SportType typeOfSport, String firstCompetitor, String secondCompetitor) {
        super(name, date, startHour, endHour, description);
        setPlace(place);
        setTypeOfSport(typeOfSport);
        setFirstCompetitor(firstCompetitor);
        setSecondCompetitor(secondCompetitor);
    }

    @Override
    public void displayEvent() {
        System.out.print("Location:             " + getPlace() + "\n" +
                         "Sport:                " + getTypeOfSport() + "\n" +
                         "First competitor:     " + getFirstCompetitor() + "\n" +
                         "Second competitor:    " + getSecondCompetitor() + "\n");
    }

    @Override
    public void deleteEvent(Day day, String nameOfEvent) {

    }

    private String getPlace() {
        return place;
    }

    private SportType getTypeOfSport() {
        return typeOfSport;
    }

    private void setPlace(String place) {
        this.place = place;
    }

    private String getFirstCompetitor() {
        return firstCompetitor;
    }

    private String getSecondCompetitor() {
        return secondCompetitor;
    }

    private void setTypeOfSport(SportType typeOfSport) {
        this.typeOfSport = typeOfSport;
    }

    private void setFirstCompetitor(String firstCompetitor) {
        this.firstCompetitor = firstCompetitor;
    }

    private void setSecondCompetitor(String secondCompetitor) {
        this.secondCompetitor = secondCompetitor;
    }
}
