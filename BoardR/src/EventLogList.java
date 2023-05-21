import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventLogList {
    private static final List<String> eventLog = new ArrayList<>();
    public void eventAdd(String eventName, LocalDateTime timestamp){
        eventLog.add(String.format("%s %s",
                eventName, timestamp.format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm:ss"))));
    }
}

