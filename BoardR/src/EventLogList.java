import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventLogList {
    private static final List<String[]> eventLog = new ArrayList<>();
    private static final int EVENT_ID = 0;
    private static final String DATE_TIME_FORMAT = "dd-MM-yy hh:mm:ss";

    public static void eventAdd(EventType eventName, LocalDateTime timestamp, UUID id){
        eventLog.add(new String[]{id.toString(),
                eventName.toString(),
                timestamp.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)),});
    }
    public static void eventAdd(EventType eventName, LocalDateTime timestamp, UUID id, String... args){
        eventLog.add(new String[]{id.toString(),
                eventName.toString(),
                timestamp.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)),
                args[0],
                args[1]});
    }
    public static List<String[]> getEventLog(String target){
        List<String[]> events = new ArrayList<>();
        for (String[] event:eventLog) {
            if (event[EVENT_ID].equals(target)) events.add(event);
        }
        return events;
    }
}