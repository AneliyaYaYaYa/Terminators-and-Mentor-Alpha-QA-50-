package Student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private final List<Integer> grades;

    public Student(String name) {
       setName(name);
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

  public void addGrade(int value){
        grades.add(value);
    }

    public List<Integer> getGrades() {
        return grades;
    }
}
