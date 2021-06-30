package entities;

/**
 * Created by desenv4 on 30/06/2021.
 */
public class Account {

    private int number;
    private String holder;
    private double balance;

    public Account(int number, String holder){
        this.number = number;
        this.holder = holder;
    }

    public Account(int number, String holder, double initDeposit){
        this.number = number;
        this.holder = holder;
        deposit(initDeposit);
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public void  deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount + 5;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}
