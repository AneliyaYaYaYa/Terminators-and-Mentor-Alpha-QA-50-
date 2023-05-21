import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventLogList {
    private static final List<String[]> eventLog = new ArrayList<>();

    public static void eventAdd(EventType eventName, LocalDateTime timestamp, UUID id){
        eventLog.add(new String[]{eventName.toString(),
                                timestamp.format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm:ss")),
                                id.toString()});
    }
    public static List<String[]> getEventLog(String target){
        List<String[]> events = new ArrayList<>();
        for (String[] event:eventLog) {
            if (event[2].equals(target)) events.add(event);
        }
        return events;
    }
}

