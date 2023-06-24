public class Varargs {

    public static void main(String[] args) {

        greet("Hello");
        greet("Hello","hristo","Mitko","Petko");

    }

    // static void greet(String greeting, String... names) {
    //     if (names.length == 0) {
    //         System.out.printf("%s!%n", greeting);
    //         return;
    //     }
    //     for (String name : names) {
    //         System.out.printf("%s, %s!%n", greeting, name);
    //     }
    // }

    static void greet ( String greeting, String... names){
        if (names.length == 0 ) {
            System.out.printf("%s!\n",greeting);
            return;
        }
        for(String name : names ) {
            System.out.printf("%s!, %s!\n",greeting,name);
        }
    }
}


