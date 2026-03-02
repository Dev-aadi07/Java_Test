package banking_system;

import banking_system.exception.InvalidAmountException;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(String acc, String name, double balance, int pin) throws InvalidAmountException {
        super(acc, name, balance, pin);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        credit(amount);
        System.out.println("Cash deposit successful in Current Account");
    }

    @Override
    public void deposit(double amount, String mode) throws InvalidAmountException {
        credit(amount);
        System.out.println("Deposit via " + mode + " successful in Current Account");
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        debit(amount);
        System.out.println("Withdrawal successful from Current Account");
    }
}
