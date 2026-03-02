package banking_system;

import banking_system.exception.InsufficientBalanceException;
import banking_system.exception.InvalidAmountException;

public interface BankingOperations {
	public void deposit(double amount) throws InvalidAmountException;
	public void deposit(double amount, String mode) throws InvalidAmountException;
	public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;
}
