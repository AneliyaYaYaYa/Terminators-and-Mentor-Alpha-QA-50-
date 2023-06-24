public class Person {
    private String name;
    private String lastName;
    private int age;

    public static void main(String[] args) {
        Person person = new Person("John", "Nikolov", 25); // Създаване на обект от класа Person
        person.introduce();
    }


    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public void introduce() {
        System.out.printf("Hello, my name is %s %s and I am %d years old.", name,lastName, age);
    }


}
