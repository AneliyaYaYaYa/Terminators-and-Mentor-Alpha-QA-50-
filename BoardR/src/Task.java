import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task extends BoardItem{
    private static final int ASSIGNEE_MIN_LENGTH = 5;
    private static final int ASSIGNEE_MAX_LENGTH = 30;
    private static final String ASSIGNEE_ERROR =
            String.format("Please provide a name with length between %d and %d chars",
                    ASSIGNEE_MIN_LENGTH,
                    ASSIGNEE_MAX_LENGTH);
    private String assignee;

    Task(String title, String assignee, LocalDate input) {
        super(title, input);
        addAssignee(assignee);
        advanceStatus(); // fix to not add an event when called here.
    }
    public void setAssignee(String name){
        String oldName = getAssignee();
        addAssignee(name);
        EventLogList.eventAdd(EventType.NEW_ASSIGNEE, LocalDateTime.now(), this.objID, oldName, name);
    }
    private void addAssignee(String assignee){
        if (assignee.length() >= ASSIGNEE_MIN_LENGTH && assignee.length() <= ASSIGNEE_MAX_LENGTH)
            this.assignee = assignee;
        else throw new IllegalArgumentException(ASSIGNEE_ERROR);
    }
    public String getAssignee() {
        return assignee;
    };
}