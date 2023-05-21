import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class BoardItem {

    private static final int MAX_TITLE_LENGTH = 30;
    private static final int MIN_TITLE_LENGTH = 5;
    private static final String ERROR_TITLE_LENGTH = String.format(
            "Title must be between %d and %d characters.", MIN_TITLE_LENGTH, MAX_TITLE_LENGTH);
    private static final String ERROR_DUE_DATE = "Due date cannot be in the past.";

    private String title;
    private LocalDate dueDate;
    protected Status status;
    protected final List<EventLog> history; //protected so that Task can use it as well


    public BoardItem(String title, LocalDate dueDate, Status initialStatus) {
        history = new ArrayList<>(); //initialize here, so that we can save space in the memory otherwise Null pointer ex error
        validateTitle(title);
        this.title = title;
        validateDueDate(dueDate);
        this.dueDate = dueDate;
        this.status = initialStatus;
        history.add(new EventLog(String.format(
                "Item created: %s", viewInfo())));
    }

    public List<EventLog> getHistory() {
        return new ArrayList<>(history);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        history.add(new EventLog(String.format(
                "Title changed from %s to %s", getTitle(), title)));
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        validateDueDate(dueDate);
        history.add(new EventLog(String.format(
                "DueDate changed from %s to %s", getDueDate(), dueDate)));
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        history.add(new EventLog(String.format(
                "Status changed from %s to %s", getStatus(), status)));
        this.status = status;
    }

    protected void revertStatus() {
        if (status != Status.OPEN) {
            setStatus(Status.values()[status.ordinal() - 1]);
        } else {
            history.add(new EventLog(String.format(
                    "Can't revert, already at %s", Status.values()[0])));
        }
    }

    protected void advanceStatus() {
        if (status != Status.VERIFIED) {
            setStatus(Status.values()[status.ordinal() + 1]);
        } else {
            history.add(new EventLog(String.format(
                    "Can't advance, already at %s", Status.values()[Status.values().length - 1])));
        }
    }

    public String viewInfo() {
        //return String.format("%s, [%s | %tY-%tm-%td ]", title, status, dueDate, dueDate, dueDate);
        return String.format("%s, [%s | %s ]", title, status, dueDate);
    }


    public void displayHistory() {
        for (EventLog event : getHistory()) {
            System.out.println(event.viewInfo());
        }
    }

    private static void validateTitle(String title) {
        if (title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(ERROR_TITLE_LENGTH);
        }
    }

    private static void validateDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(ERROR_DUE_DATE);
        }
    }
}


