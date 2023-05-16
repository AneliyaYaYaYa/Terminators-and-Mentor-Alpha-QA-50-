import java.time.LocalDate;

public class Main {

    public static void main (String[] args){
        BoardItem item = new BoardItem("this is a valid title", LocalDate.now().plusDays(2));
        System.out.println(item.viewInfo());
        Board.addItems(item);
    }
}