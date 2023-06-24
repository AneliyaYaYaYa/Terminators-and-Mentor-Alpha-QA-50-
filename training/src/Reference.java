

public class Reference {
    private String name;

    public static void main(String[] args) {
        Reference person = new Reference();

        person.setName("John");
        String name = person.getName();

        System.out.printf("%s",name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


