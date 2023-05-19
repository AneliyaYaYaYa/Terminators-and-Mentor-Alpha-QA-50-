public enum Status {
    OPEN,
    TODO,
    INPROGRESS,
    DONE,
    VERIFIED;


    @Override
    public String toString() {
        switch (this) {
            case OPEN:
                return "Open";
            case TODO:
                return "To Do";
            case INPROGRESS:
                return "In Progress";
            case DONE:
                return "Done";
            case VERIFIED:
                return "Verified";

        }
        return "Unknown";
    }
}



