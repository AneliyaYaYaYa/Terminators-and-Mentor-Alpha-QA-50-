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
        if (description.length() <= DESCRIPTION_MIN_LENGTH || description == null) {
            throw new IllegalArgumentException(DESCRIPTION_ERROR_MSG);
        }
        this.description = description;
    }

    public EventLog() {
        throw new IllegalArgumentException(DESCRIPTION_ERROR_MSG);
    }

    public String getDescription() {
        return description;
    }


    public String viewInfo() {
        return String.format("[%td-%tB-%tY %tr] %s", timeStamp, timeStamp, timeStamp, timeStamp, getDescription());
    }

}
