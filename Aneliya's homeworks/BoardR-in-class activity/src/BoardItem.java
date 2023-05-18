import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BoardItem {

    private static final int MAX_TITLE_LENGTH = 30;
    private static final int MIN_TITLE_LENGTH = 5;
    private static final String ERROR_TITLE_LENGTH = String.format(
            "Title must be between %d and %d characters.", MIN_TITLE_LENGTH, MAX_TITLE_LENGTH);
    private static final String ERROR_DUE_DATE = "Due date cannot be in the past.";

    private String title;
    private LocalDate dueDate;
    private Status status;

   private List<EventLog> history;


    public BoardItem(String title, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        this.status = Status.Open;
        history = new ArrayList<EventLog>();
        //history.add("Item created");
    }

    public List<EventLog> getHistory() {
        return new ArrayList<>(history);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(ERROR_TITLE_LENGTH);
        }

        this.title = title;
        // history.add(title);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) { //it says in the descr IT CAN BE CHANGED
        if (dueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException(ERROR_DUE_DATE);
        }
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void revertStatus(){
        switch (status){
            case Open:
                break;
            case Todo:
                status =   Status.Open;
                break;
            case InProgress:
                status =   Status.Todo;
                break;
            case Done:
                status =  Status.InProgress;
                break;
            case Verified:
                status =   Status.Done;
                break;
        }

    }

    public void advanceStatus() {
        switch (status) {
            case Open:
                status =  Status.Todo;
                break;
            case Todo:
                status = Status.InProgress;
                break;
            case InProgress:
                status = Status.Done;
                break;
            case Done:
                status = Status.Verified;
                break;
            case Verified:
                break;
        }

    }

    public String viewInfo() {
        //return String.format("%s, [%s | %tY-%tm-%td ]", title, status, dueDate, dueDate, dueDate);
        return String.format("%s, [%s | %s ]", title, status, dueDate);

    }


//    public String displayHistory() {
//    StringBuilder displayedHistory = new StringBuilder("Items created: ");
//    for (EventLog log : history){
//        displayedHistory.append(String.format("%s", log);
//    }
//        return displayedHistory.toString();
//    }


}
