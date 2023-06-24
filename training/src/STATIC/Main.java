package STATIC;

public class Main {
    public static void main(String[] args) {
        Static person = new Static("Hristo",25);
        Static person1 = new Static("Mitko",53);

        System.out.println(person1.getId());
        System.out.println(Static.getPeopleCount());
    }
}
