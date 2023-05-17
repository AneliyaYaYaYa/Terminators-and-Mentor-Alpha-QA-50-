import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BoardItem {
    public static final int TITLE_MIN_LENGTH = 5;
    public static final int TITLE_MAX_LENGTH = 30;
    public static final String TITLE_ERROR =
            String.format("Please provide a title with length between %d and %d chars",
                    TITLE_MIN_LENGTH,
                    TITLE_MAX_LENGTH);
    private String title;
    private LocalDate dueDate;
    private Status status;
    private static boolean added = false;
    private final List<String> EventLog;

    BoardItem(String title, LocalDate input) {
        setTitle(title);
        long dateOffset = ChronoUnit.DAYS.between(LocalDate.now(), input);
        setDueDate(dateOffset);
        setStatus();
        if(this.title != null && this.dueDate!=null)
            Board.addItems(this);
        EventLog = new ArrayList<>();
        EventLog.add(String.format("Item created '%s' ", title) + LocalDateTime.now());
        setAdded();
    }
    //begin setters
    public void newTitle (String title){
        EventLog.add(String.format("Title changed from '%s' to '%s'", this.title, title) + LocalDateTime.now());
        setTitle(title);
    }
    private void setTitle(String title){
        if (title.length() >= TITLE_MIN_LENGTH && title.length() <= TITLE_MAX_LENGTH)
            this.title = title;
        else throw new IllegalArgumentException(TITLE_ERROR);
    }
    public void newDueDate (LocalDate input) {
        EventLog.add(String.format("Due date changed from '%s' to '%s' ",
                this.dueDate,
                ChronoUnit.DAYS.between(LocalDate.now(), input)) + LocalDateTime.now());
        long dateOffset = ChronoUnit.DAYS.between(LocalDate.now(), input);
        setDueDate(dateOffset);
    }
    private void setDueDate(long dateOffset) {
        if (dateOffset >= 0)
            this.dueDate = LocalDate.now().plusDays(dateOffset);
        else System.out.println("Invalid due date");
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
         EventLog.add(String.format("Status changed from '%s' to '%s' ",
                 setStatus(index-1), getStatus()) + LocalDateTime.now());
     }
     public void revertStatus(){
         int index = status.ordinal();
         if (index != 0) index--;
         status = setStatus(index);
         EventLog.add(String.format("Status changed from '%s' to '%s' ",
                 setStatus(index+1), getStatus()) + LocalDateTime.now());
     }
     private void setAdded(){
        added = true;
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
    public String viewInfo(){
        return String.format("%s ", getTitle()) +
               String.format("[%s |", getStatus()) +
               String.format(" %s]", getDueDate());
    }
    public void viewEvents(){
        for (String event:EventLog) {
            System.out.println(event);
        }
    }

    public static boolean isAdded() {
        return added;
    }
    //end getters
}