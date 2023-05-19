import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
        System.out.println(task.viewInfo()); //correct status here
        task.advanceStatus();
        task.advanceStatus();
        task.setAssignee("Gosho");
        task.displayHistory(); //incorect here


    }
}