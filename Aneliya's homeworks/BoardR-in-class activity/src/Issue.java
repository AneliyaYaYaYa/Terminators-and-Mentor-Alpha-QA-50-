import java.time.LocalDate;

public class Issue extends BoardItem {

    private String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate);
        setDescription(description);

    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    private static void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("No description.");
        }
    }
}
