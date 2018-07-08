package theblackpanther;

public abstract class Event {
    private String name;
    private String date;
    private String startHour;
    private String endHour;
    private String description;

    Event(String name, String date, String startHour, String endHour, String description) {
        setName(name);
        setDate(date);
        setStartHour(startHour);
        setEndHour(endHour);
        setDescription(description);
    }

    public Event() {

        this("", "", "", "", "");
    }
    public Event(String name) {

        this(name, "", "", "", "");
    }
    public Event(String name, String date) {
        this(name, date, "", "", "");
    }
    public Event(String name, String date, String start_hour) {
        this(name, date, start_hour, "", "");
    }

    public Event(String name, String date, String start_hour, String end_hour) {
        this(name, date, start_hour, end_hour, "");
    }


    public abstract void  displayEvent();

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    String getStartHour() {
        return startHour;
    }

    String getEndHour() {
        return endHour;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

