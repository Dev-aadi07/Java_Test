package banking_system;

import banking_system.exception.InvalidAmountException;
import banking_system.exception.InsufficientBalanceException;

public abstract class BankAccount implements BankingOperations {

	private String accountNumber;
	private String accountHolder;
	private double balance;
	private int pin;

	public BankAccount(String acc, String name, double balance, int pin) throws InvalidAmountException {
		if (balance < 0) {
			throw new InvalidAmountException("Balance cannot be negative");
		}
		this.accountNumber = acc;
		this.accountHolder = name;
		this.balance = balance;
		this.pin = pin;
	}

	protected void credit(double amount) throws InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Deposit amount must be positive");
		}
		balance += amount;
	}

	protected void debit(double amount) throws InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Withdrawal amount must be positive");
		}
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
		balance -= amount;
	}

	public boolean validatePin(int enteredPin) {
		return this.pin == enteredPin;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountHolder() {
		return accountHolder;
	}
}
