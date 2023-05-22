import java.time.LocalDate;
import java.util.Objects;

public class Issue extends BoardItem{
    private static final String NO_DESCRIPTION = "No description";
    private String description;
    Issue(String title, String description, LocalDate input) {
        super(title, input);
        setDescription(description);
    }

    private void setDescription(String description) {
        this.description = Objects.requireNonNullElse(description, NO_DESCRIPTION);
    }
}