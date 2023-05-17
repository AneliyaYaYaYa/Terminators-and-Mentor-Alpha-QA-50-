import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final List<BoardItem> items = new ArrayList<>();
    public static void addItems(BoardItem item){
            items.add(item);
            if (BoardItem.isAdded()) throw new IllegalArgumentException(String.format("'%s' already in the list",
                    item.getTitle()));
    }
    public static void getAllItems(){
        for (BoardItem item:items) {
            item.viewInfo();
        }
    }
}