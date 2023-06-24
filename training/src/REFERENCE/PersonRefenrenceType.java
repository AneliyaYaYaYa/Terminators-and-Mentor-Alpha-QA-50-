package REFERENCE;

public class PersonRefenrenceType {
    private String name;
    private String lastaName;
    private int age;

    public PersonRefenrenceType(String name, String lastaName, int age) {
        this.name = name;
        this.lastaName = lastaName;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastaName() {
        return lastaName;
    }

    public void setLastaName(String lastaName) {
        this.lastaName = lastaName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String print() {
        return String.format("I am %s %s %d old.", name, lastaName, age);
    }
    // public static void main(String[] args) {
    //         Person p1 = person1();
    //         Person p2 = person2();
    //          p2 = p1 ;

    //     System.out.println(p2);
    //     }

    //     public static Person person1 () {
    //         String firstName = "Ivan";
    //         String lastName = "Ivanov";
    //         int age = 25;

    //         return new Person(firstName, lastName, age);
    //     }

    //     public static Person person2 () {
    //         String firstName = "Mitko";
    //         String lastName = "Nikolov";
    //         int age = 19;

    //         return new Person(firstName, lastName, age);
    //     }
}

