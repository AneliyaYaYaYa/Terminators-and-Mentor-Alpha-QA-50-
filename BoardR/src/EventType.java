public enum EventType {
    NEW{
        @Override
            public String toString() {
            return "Item created";
        }
    },
    NEW_TITLE{
        @Override
        public String toString() {
            return "Title changed";
        }
    },
    NEW_DATE{
        @Override
        public String toString() {
            return "Due date changed";
        }
    },
    NEW_STATUS{
        @Override
        public String toString() {
            return "Status changed";
        }
    },
    NEW_ASSIGNEE{
        @Override
        public String toString() {return "Assignee changed";}
    }
}