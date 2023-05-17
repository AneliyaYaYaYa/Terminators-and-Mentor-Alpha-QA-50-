import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.status);
        item.advanceStatus();
        System.out.println(item.status);
        item.advanceStatus();
        System.out.println(item.status);
        item.revertStatus();
        System.out.println(item.status);

    }
}