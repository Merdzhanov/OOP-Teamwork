package theblackpanther;

public class BirthdayEvent extends Event {

    private String place;
    private String nameOfBirthdayPerson;
    private String gift;

    public BirthdayEvent(String name, String date, String startHour, String endHour,
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

    private String getNameOfBirthdayPerson() {
        return nameOfBirthdayPerson;
    }

    private void setNameOfBirthdayPerson(String nameOfBirthdayPerson) {
        this.nameOfBirthdayPerson = nameOfBirthdayPerson;
    }

    private String getGift() {
        return gift;
    }

    private void setGift(String gift) {
        this.gift = gift;
    }

}
