package theblackpanther;

public class BirhtdayEvent extends Event {

    private String place;
    private String nameOfBirthdayPerson;
    private String gift;

    public BirhtdayEvent(String name, String date, String startHour, String endHour,
                         String description, String place, String nameOfBirthdayPerson, String gift) {
        super(name, date, startHour, endHour, description);
        setPlace(place);
        setNameOfBirthdayPerson(nameOfBirthdayPerson);
        setGift(gift);
    }

    @Override
    public void displayEvent() {
        System.out.print("Location:             " + getPlace() + "\n" +
                         "Birthday person:      " + getNameOfBirthdayPerson() + "\n" +
                         "gift:                 " + getGift() + "\n");
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNameOfBirthdayPerson() {
        return nameOfBirthdayPerson;
    }

    public void setNameOfBirthdayPerson(String nameOfBirthdayPerson) {
        this.nameOfBirthdayPerson = nameOfBirthdayPerson;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

}
