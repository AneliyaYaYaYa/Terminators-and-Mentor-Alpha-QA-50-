package Student;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Ivan");
        student.addGrade(5);
        student.addGrade(6);
        student.addGrade(3);

        System.out.printf("Student name: %s\n",student.getName());
        System.out.printf("Grades: %s",student.getGrades());
    }
}
