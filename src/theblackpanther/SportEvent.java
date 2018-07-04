package theblackpanther;

public class SportEvent extends Event{

    private String place;
    private SportType typeOfSport;
    private String firstCompetitor;
    private String secondCompetitor;

    public SportEvent(String name, String date, String startHour, String endHour, String description, String place,
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
    public void deleteEvent() {

    }



    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public SportType getTypeOfSport() {
        return typeOfSport;
    }

    public void setTypeOfSport(SportType typeOfSport) {
        this.typeOfSport = typeOfSport;
    }

    public String getFirstCompetitor() {
        return firstCompetitor;
    }

    public void setFirstCompetitor(String firstCompetitor) {
        this.firstCompetitor = firstCompetitor;
    }

    public String getSecondCompetitor() {
        return secondCompetitor;
    }

    public void setSecondCompetitor(String secondCompetitor) {
        this.secondCompetitor = secondCompetitor;
    }
}
