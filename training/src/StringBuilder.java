public class StringBuilder {
    public static void main(String[] args) {
        java.lang.StringBuilder result = new java.lang.StringBuilder();
        result.append("Hello");
        result.append(" ");
        result.append("World!");
        result.deleteCharAt(result.length() - 1 );
        result.append("?");

        String message = result.toString();  //използваме toString метода за да преобразуваме на обект в стринг

        System.out.println(message);
    }
}