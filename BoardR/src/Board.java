import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final List<BoardItem> items = new ArrayList<>();
    private static final String ITEM_EXISTS = " already in the list";

    public static void addItems(BoardItem item){
            if (BoardItem.isAdded()) throw new IllegalArgumentException(item.getTitle() + ITEM_EXISTS);
            else items.add(item);
    }
    public static void getAllItems(){
        for (BoardItem item:items) {
            item.viewInfo();
        }
    }
}