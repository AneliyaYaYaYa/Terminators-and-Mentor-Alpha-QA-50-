import java.time.LocalDate;


public class BoardItem {

    private static final int MAX_TITLE_LENGTH = 30;
    private static final int MIN_TITLE_LENGTH = 5;

    private String title;
    private LocalDate dueDate;
    public String status;

//    public BoardItem(String title, LocalDate dueDate, String status) {
//        setTitle(title);
//        setDueDate(dueDate); //always future date? date format?
//        this.status = status;
//    }

    public BoardItem(String title, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        this.status = String.valueOf(Status.Open);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title.length() > MIN_TITLE_LENGTH && title.length() < MAX_TITLE_LENGTH) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title must be between 5 and 30 characters.");
        }
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    private void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void revertStatus(){
        switch (status){
            case "Open":
                break;
            case "Todo":
                status =   String.valueOf(Status.Open);
                break;
            case "InProgress":
                status =   String.valueOf(Status.Todo);
                break;
            case "Done":
                status =   String.valueOf(Status.InProgress);
                break;
            case "Verified":
                status =   String.valueOf(Status.Done);
                break;
        }

    }

    public void advanceStatus() {
        switch (status) {
            case "Open":
                status =  String.valueOf(Status.Todo);
                break;
            case "Todo":
                status = String.valueOf(Status.InProgress);
                break;
            case "InProgress":
                status = String.valueOf(Status.Done);
                break;
            case "Done":
                status = String.valueOf(Status.Verified);
                break;
            case "Verified":
                break;
        }

    }

    public String viewInfo() {
        String info = String.format("%s, [%s | %tY-%tm-%td ]", title, status, dueDate, dueDate, dueDate);
                return info;
    }


}
