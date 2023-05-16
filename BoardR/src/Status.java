public enum Status {
        OPEN{
            @Override
            public String toString() {
                return "Open";
            }
        },
        TODO{
            @Override
            public String toString() {
                return "Todo";
            }
        },
        INPROGRESS{
            @Override
            public String toString() {
                return "InProgress";
            }
        },
        DONE{
            @Override
            public String toString() {
                return "Done";
            }
        },
        VERIFIED{
            @Override
            public String toString() {
                return "Verified";
            }
        };
}