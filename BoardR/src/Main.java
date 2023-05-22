import java.time.LocalDate;

public class Main {

    public static void main (String[] args) {
        Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
        task.advanceStatus();
        task.advanceStatus();
        task.setAssignee("Gosho");
        task.displayHistory();

    }
}