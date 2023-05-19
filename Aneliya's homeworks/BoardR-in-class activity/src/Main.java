import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {


        BoardItem item = new BoardItem("Refactor this mess", LocalDate.now().plusDays(2));
       item.setDueDate(item.getDueDate().plusYears(2));
        item.setTitle("Not that important");
        item.revertStatus();
        item.advanceStatus();
        item.revertStatus();

        item.displayHistory();

        System.out.println("\n--------------\n");

        BoardItem anotherItem = new BoardItem("Don't refactor anything",  LocalDate.now().plusDays(10));
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        anotherItem.displayHistory();

    }
}