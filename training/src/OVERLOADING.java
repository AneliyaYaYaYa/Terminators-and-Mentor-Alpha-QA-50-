public class OVERLOADING {

    //EXAMPLE OVERLOADING METHOD;
    public static void main(String[] args) {
        OVERLOADING calculator = new OVERLOADING();

        int number = calculator.add(10,30);
        System.out.println(number);

        double test = calculator.add(10.2,94.1);
        System.out.println(test);
    }

    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return  a + b ;
    }
}

