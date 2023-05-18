import java.util.ArrayList;
import java.util.List;

public class Board {

    private static List<BoardItem> items;

    public Board(){
        items = new ArrayList<>();
    }

    public List<BoardItem> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem (BoardItem value){
        if (items.contains(value)) {
            throw new IllegalArgumentException("Item already in the list.");
            //return;
        }
        items.add(value);
    }

    public int totalItems(){
        return items.size();
    }
}
