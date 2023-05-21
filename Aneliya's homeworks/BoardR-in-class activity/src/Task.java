import java.time.LocalDate;

public class Task extends BoardItem {

    private static final int NAME_MIN_LENGTH = 5;
    private static final int NAME_MAX_LENGTH = 30;
    private static final String NAME_LENGTH_ERROR = String.format(
            "Assignee name should be between %d and %d characters.", NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private static final String NULL_ERROR = "Assignee name cannot be null.";
    private String assignee;
    //private final Status initialStatus = Status.TODO;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate, Status.TODO);
        //this.status = Status.TODO;
        validateAssignee(assignee);
        this.assignee = assignee;

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
    public void revertStatus() {
        if (status != Status.TODO) {
            setStatus(Status.values()[status.ordinal() - 1]);
        } else {
            history.add(new EventLog(String.format(
                    "Can't revert, already at %s", Status.values()[0])));
        }
    }

    private static void validateAssignee(String assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        } else if (assignee.length() < NAME_MIN_LENGTH || assignee.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }
}
