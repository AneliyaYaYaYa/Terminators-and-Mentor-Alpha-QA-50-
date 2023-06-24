public class Account {

    private final String nameOwner;
    private double balance;

    public Account(String nameOwner, double balance) {
        this.nameOwner = nameOwner;
        this.balance = balance;
    }

    public Account(String nameOwner) {
        this(nameOwner,0);
    }
    public void deposit(double sum){
        balance += sum;
    }
}
