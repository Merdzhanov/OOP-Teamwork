package theblackpanther;

public interface Editable {
    void edit(String name, String date, String startHour, String endHour, String description);
    // Add Override for each subclass in Event
}
