import java.time.LocalDate;

public class Issue extends BoardItem {

    private  String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate, Status.OPEN);
        setDescription(description);

    }

    public void setDescription(String description) {
        if (description.isEmpty()) {
            description = "No description.";
        }
        this.description = description;
    }


}
