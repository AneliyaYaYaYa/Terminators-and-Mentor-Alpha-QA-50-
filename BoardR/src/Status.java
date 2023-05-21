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
                return "To do";
            }
        },
        INPROGRESS{
            @Override
            public String toString() {
                return "In Progress";
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