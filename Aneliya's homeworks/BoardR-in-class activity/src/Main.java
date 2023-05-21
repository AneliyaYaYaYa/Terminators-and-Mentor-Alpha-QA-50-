import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Issue issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
        Task task = new Task("Test the application flow", "Pesho", tomorrow);

        Board board = new Board();

        board.addItem(issue);
        board.addItem(task);
        System.out.println(board.totalItems()); // 2
//        Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
//        System.out.println(task.viewInfo()); //correct status here
//        task.advanceStatus();
//        task.advanceStatus();
//        task.setAssignee("Gosho");
//        task.displayHistory(); //incorect here


    }
}