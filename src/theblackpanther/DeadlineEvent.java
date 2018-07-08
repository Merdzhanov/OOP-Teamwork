package theblackpanther;

public class DeadlineEvent extends Event implements Editable {

    DeadlineEvent(String name, String date, String startHour, String endHour, String description) {
        super(name, date, startHour, endHour, description);
    }

    @Override
    public void displayEvent() {
        System.out.printf("Event Name: %s\nEvent Date: %s\nEvent Start Time: %s\nEvent End Time: %s\nEvent Description: %s\n",
                getName(), getDate(), getStartHour(), getEndHour(), getDescription());
    }

    @Override
    public void edit(String name, String date, String startHour, String endHour, String description) {
        super.setName(name);
        super.setDate(date);
        super.setStartHour(startHour);
        super.setEndHour(endHour);
        super.setDescription(description);
    }
}
