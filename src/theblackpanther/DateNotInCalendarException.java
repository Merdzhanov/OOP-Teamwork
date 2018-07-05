package theblackpanther;

public class DateNotInCalendarException extends IllegalArgumentException{
    private static final long serialVersionUID = 7718828512143293558L;

    private final WrongDateElementType code;

    public DateNotInCalendarException(WrongDateElementType code) {
        super();
        this.code = code;
    }
    public DateNotInCalendarException(String message, Throwable cause, WrongDateElementType code) {
        super(message, cause);
        this.code = code;
    }

    public DateNotInCalendarException(String message, WrongDateElementType code) {
        super(message);
        this.code = code;
    }


    public DateNotInCalendarException(Throwable cause, WrongDateElementType code) {
        super(cause);
        this.code = code;
    }

    public WrongDateElementType getCode() {
        return this.code;
    }

}

