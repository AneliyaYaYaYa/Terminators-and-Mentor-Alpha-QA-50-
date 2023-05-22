import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class BoardItem {
    private static final int TITLE_MIN_LENGTH = 5;
    private static final int TITLE_MAX_LENGTH = 30;
    private static final String TITLE_ERROR =
            String.format("Please provide a title with length between %d and %d chars",
                    TITLE_MIN_LENGTH,
                    TITLE_MAX_LENGTH);
    private static final String INVALID_DUE_DATE = "Invalid due date";
    private static final int EVENT_NAME = 1;
    private static final int EVENT_TIME = 2;
    private static final int MAX_STATUS = 4;
    private static final int MIN_STATUS = 0;
    private static final int MIN_DATE_OFFS = 0;
    private static final int OLD_VALUE = 3;
    private static final int NEW_VALUE = 4;
    private String title;
    private LocalDate dueDate;
    private Status status;
    private final UUID objID;
    private static boolean added = true;

    BoardItem(String title, LocalDate input) {
        setAdded();
        setTitle(title);
        long dateOffset = ChronoUnit.DAYS.between(LocalDate.now(), input);
        setDueDate(dateOffset);
        setStatus();
        if(this.title != null && this.dueDate!=null)
            Board.addItems(this);
        objID = UUID.randomUUID();
        EventLogList.eventAdd(EventType.NEW, LocalDateTime.now(), this.objID);
        setAdded();
    }
    //begin setters
    public void newTitle (String title){
        EventLogList.eventAdd(EventType.NEW_TITLE, LocalDateTime.now(), this.objID, getTitle(), title);
        setTitle(title);
    }
    private void setTitle(String title){
        if (title.length() >= TITLE_MIN_LENGTH && title.length() <= TITLE_MAX_LENGTH)
            this.title = title;
        else throw new IllegalArgumentException(TITLE_ERROR);
    }
    public void newDueDate (LocalDate input) {
        String oldDate = getDueDate().toString();
        long dateOffset = ChronoUnit.DAYS.between(LocalDate.now(), input);
        setDueDate(dateOffset);
        EventLogList.eventAdd(EventType.NEW_DATE, LocalDateTime.now(), this.objID, oldDate, getDueDate().toString());
    }
    private void setDueDate(long dateOffset) {
        if (dateOffset >= MIN_DATE_OFFS)
            this.dueDate = LocalDate.now().plusDays(dateOffset);
        else System.out.println(INVALID_DUE_DATE);
     }
    private void setStatus(){
        status = Status.OPEN;
    }
    private Status setStatus(int index) {
        Status[] values = Status.values();
        return values[index];
    }
     public void advanceStatus(){
        String oldStatus = getStatus().toString();
        int index = status.ordinal();
        if (index != MAX_STATUS) index++;
        status = setStatus(index);
        EventLogList.eventAdd(EventType.NEW_STATUS, LocalDateTime.now(), this.objID, oldStatus, getStatus().toString());
     }
     public void revertStatus(){
        String oldStatus = getStatus().toString();
        int index = status.ordinal();
        if (index != MIN_STATUS) index--;
        status = setStatus(index);
        EventLogList.eventAdd(EventType.NEW_STATUS, LocalDateTime.now(), this.objID, oldStatus, getStatus().toString());
     }
     private void setAdded(){
        added = !added;
     }
    //end setters
    // begin getters
    public String getTitle(){
        return title;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    public Status getStatus(){
        return status;
        }
    public void viewInfo(){
        System.out.printf("%s [%s | %s]%n", getTitle(), getStatus(), getDueDate());
    }
    public void displayHistory(){
        displayHistory(getItemID());
    }
    public void displayHistory(String objID){
        for (String[] event : EventLogList.getEventLog(objID)) {
            if (event.length > 3/*event[EVENT_NAME].equals(EventType.NEW_TITLE.toString()) ||
                    event[EVENT_NAME].equals(EventType.NEW_STATUS.toString()) ||
                    event[EVENT_NAME].equals(EventType.NEW_DATE.toString())*/)
                System.out.printf("%s %s changed from '%s' to '%s'%n",
                        event[EVENT_TIME],
                        event[EVENT_NAME],
                        event[OLD_VALUE],
                        event[NEW_VALUE]);
            else System.out.printf("%s %s%n",event[EVENT_TIME], event[EVENT_NAME]);
        }
    }
    public String getItemID(){
        return this.objID.toString();
    }

    public static boolean isAdded() {
        return added;
    }
    //end getters
}