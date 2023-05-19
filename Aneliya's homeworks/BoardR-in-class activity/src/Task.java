import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task extends BoardItem{

    //historyEventLog issue!
    //use the Hints!!
    private static final int NAME_MIN_LENGTH = 5;
    private static final int NAME_MAX_LENGTH = 30;
    public static final String NAME_LENGTH_ERROR = String.format(
            "Assignee name should be between %d and %d characters.", NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    public static final String NULL_ERROR = "Assignee name cannot be null.";
    private String assignee;
    private Status initialStatus = Status.TODO;
//    private final List<EventLog> history;

    public Task(String title,  String assignee, LocalDate dueDate) {
        super(title, dueDate);
        validateAssignee(assignee);
        this.assignee = assignee;
        setStatus(initialStatus);
//        this.history = new ArrayList<>();
//        history.add(new EventLog(String.format(
//                "Item created: %s", viewInfo())));
    }

    public Status getInitialStatus() {
        return initialStatus;
    }

    private void setInitialStatus(Status initialStatus) {
        this.initialStatus = Status.TODO;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        validateAssignee(assignee);
        history.add(new EventLog(String.format(
                "Assignee changed from %s to %s", getAssignee(), assignee)));
        this.assignee = assignee;
    }

    @Override
    public String viewInfo() {
        return String.format("%s, [%s | %s ]", super.getTitle(), getInitialStatus(), super.getDueDate());
    }

    private static void validateAssignee(String assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        } else if (assignee.length() < NAME_MIN_LENGTH || assignee.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }
}
