import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class EventLog {

    private static final int DESCRIPTION_MIN_LENGTH = 0;
    private static final String DESCRIPTION_ERROR_MSG = "Description cannot be empty.";
    private final String description;
    private final LocalDateTime timeStamp = LocalDateTime.now();


    public EventLog(String description) {
        validateDescription(description);
        this.description = description;
    }

    public EventLog() {
        throw new IllegalArgumentException(DESCRIPTION_ERROR_MSG);
    }

//    public EventLog() { // alternative to the empty constructor above - calling the first const, giving empty String, calling the validation method -> trowing error
//        this("");
//    }

    public String getDescription() {
        return description;
    }

    public String viewInfo() {
        return String.format("[%td-%tB-%tY %tr] %s", timeStamp, timeStamp, timeStamp, timeStamp, getDescription());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formatDateTime = this.timeStamp.format(formatter);
//        return String.format("[%s] %s", formatDateTime, getDescription());
    }

    private static void validateDescription(String description) { // we can use this method or validate the descr in a setter
        if (description.length() <= DESCRIPTION_MIN_LENGTH || description == null) {
            throw new IllegalArgumentException(DESCRIPTION_ERROR_MSG);
        }
    }

}
