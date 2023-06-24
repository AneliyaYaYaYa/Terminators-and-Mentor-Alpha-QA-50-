import java.util.Scanner;

public class METHODS {
    public static void main(String[] args) {
        String name = readUserName();
        greetUser(name);

    }

    public static String readUserName() {
        System.out.print("Please, enter your name: ");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        return name;
    }


    public static void greetUser(String name) {
        System.out.println("Hello," + name + "!");
    }

}
