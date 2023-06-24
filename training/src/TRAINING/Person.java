package TRAINING;

public class Person {

    String name;
    int age;
    String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
      return   String.format("Hello i am %s  %d old, and i live on %s street", name, age, address);
    }
}


