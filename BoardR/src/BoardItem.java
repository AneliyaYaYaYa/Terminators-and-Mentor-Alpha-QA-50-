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
    public static final String INVALID_DUE_DATE = "Invalid due date";
    private String title;
    private LocalDate dueDate;
    private Status status;
    private UUID objID;
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
        EventLogList.eventAdd(EventType.NEW_TITLE, LocalDateTime.now(), this.objID);
        setTitle(title);
    }
    private void setTitle(String title){
        if (title.length() >= TITLE_MIN_LENGTH && title.length() <= TITLE_MAX_LENGTH)
            this.title = title;
        else throw new IllegalArgumentException(TITLE_ERROR);
    }
    public void newDueDate (LocalDate input) {
        EventLogList.eventAdd(EventType.NEW_DATE, LocalDateTime.now(), this.objID);
        long dateOffset = ChronoUnit.DAYS.between(LocalDate.now(), input);
        setDueDate(dateOffset);
    }
    private void setDueDate(long dateOffset) {
        if (dateOffset >= 0)
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
        int index = status.ordinal();
        if (index != 4) index++;
        status = setStatus(index);
         EventLogList.eventAdd(EventType.NEW_STATUS, LocalDateTime.now(), this.objID);
     }
     public void revertStatus(){
         int index = status.ordinal();
         if (index != 0) index--;
         status = setStatus(index);
         EventLogList.eventAdd(EventType.NEW_STATUS, LocalDateTime.now(), this.objID);
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
        System.out.println(String.format("%s ", getTitle()) +
               String.format("[%s |", getStatus()) +
               String.format(" %s]", getDueDate()));
    }
    public void viewEvents(){
        viewEvents(getItemID().toString());
    }
    public void viewEvents(String objID){
        for (String[] event : EventLogList.getEventLog(objID)) {
            System.out.println(event[0] + " " + event[1]);
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