package REFERENCE;

public class Main {
    public static void main(String[] args) {

        PersonRefenrenceType p1 = new PersonRefenrenceType("Hristo", "Hristov", 25);

        System.out.println(p1.print());

        PersonRefenrenceType p2 = new PersonRefenrenceType("Mitko", "Mitkov", 21);
        System.out.println(p2.print());

        p2 = p1 ;

        System.out.println(p2.print());
    }
}
