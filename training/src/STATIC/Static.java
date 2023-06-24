package STATIC;

public class Static {
    private String name;

    private static int nextId;

    private int id;

    public Static(String name, int id) {
       setName(name);
        this.id = Static.nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getPeopleCount() {
         return Static.nextId ;
    }

    public int getId() {
        return id;
    }
}
