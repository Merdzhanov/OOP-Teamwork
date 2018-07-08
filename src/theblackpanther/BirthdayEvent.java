package theblackpanther;

public class BirthdayEvent extends Event {

    private String place;
    private String nameOfBirthdayPerson;
    private String gift;

    BirthdayEvent(String name, String date, String startHour, String endHour,
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

    private String getNameOfBirthdayPerson() {
        return nameOfBirthdayPerson;
    }

    private String getPlace() {
        return place;
    }

    private String getGift() {
        return gift;
    }

    private void setPlace(String place) {
        this.place = place;
    }

    private void setNameOfBirthdayPerson(String nameOfBirthdayPerson) {
        this.nameOfBirthdayPerson = nameOfBirthdayPerson;
    }

    private void setGift(String gift) {
        this.gift = gift;
    }

}
