import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BoardItem {
    private String title;
    private LocalDate dueDate;
    private Status status;
    private static boolean added = false;

    BoardItem(String title, LocalDate input) {
        setTitle(title);
        long dateOffset = ChronoUnit.DAYS.between(LocalDate.now(), input);
        setDueDate(dateOffset);
        setStatus();
        if(this.title != null && this.dueDate!=null)
            Board.addItems(this);
        setAdded();
    }
    //begin setters
    private void setTitle(String title){
        if (title.length() >= 5 && title.length() <= 30)
            this.title = title;
        else System.out.println("Invalid title");
    }
    private void setDueDate(long dateOffset) {
        if (dateOffset >= 0)
            this.dueDate = LocalDate.now().plusDays(dateOffset);
        else System.out.println("Invalid due date");
     }
    private void setStatus(){
        status = Status.OPEN;
    }
    private Status setStatus(int index) {
        Status[] values = Status.values();
        return values[index];
    }
     public void advanceStatus(){
        int index = status.ordinal();
        if (index != 4) index++;
        status = setStatus(index);
     }
     public void revertStatus(){
         int index = status.ordinal();
         if (index != 0) index--;
         status = setStatus(index);
     }
     private void setAdded(){
        added = true;
     }
    //end setters
    // begin getters
    public String getTitle(){
        return title;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    public Status getStatus(){
        return status;
        }
    public String viewInfo(){
        return String.format("%s ", getTitle()) +
               String.format("[%s |", getStatus()) +
               String.format(" %s]", getDueDate());
    }

    public static boolean isAdded() {
        return added;
    }
    //end getters
}