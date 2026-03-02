package startingFromBasic;

abstract class BankAccount {
	private String accountHolder;
	private double balance;
	
	BankAccount (String name, double initialBalance) throws InvalidInputException {
		this.accountHolder = name;
		if (initialBalance>0) {			
			this.balance = initialBalance;
		} else {
			throw new InvalidInputException("Initital Balance must be positive.");
		}
	}
	
	void deposit (double amt) throws InvalidInputException{
		if (amt<=0) throw new InvalidInputException("Deposit must be positive.");
		this.balance += amt;
	}
	
	abstract boolean isWithdrawalAllowed(double amt) throws InvalidInputException, NotEnoughBalanceException;
	
	void withdraw(double amt) throws NotEnoughBalanceException, InvalidInputException {
		//validate
		if (amt <= 0) {
			throw new InvalidInputException("Withdrawl amt must be positive.");
		}
		
		if (!isWithdrawalAllowed(amt)) {
			throw new NotEnoughBalanceException("Withdrawal not allowed.");
		}
		
		balance -= amt;
	}
	
	
	double getBalance() {
		return balance;
	}
}

class SavingsAccount extends BankAccount {
	private static final double MIN_BALANCE = 1000;
	
	SavingsAccount(String name, double initialBalance) throws InvalidInputException {
		super(name, initialBalance);
		
		if (initialBalance < MIN_BALANCE) {
			throw new InvalidInputException("Savings account must have minimum balance of "+ MIN_BALANCE);
		}
	}
	
	@Override
	boolean isWithdrawalAllowed(double amt) throws InvalidInputException, NotEnoughBalanceException {
		if (getBalance() - amt < MIN_BALANCE) {
			throw new NotEnoughBalanceException("Must maintain the minimum balance: "+MIN_BALANCE);
		}
		return true;
	}
}

class CurrentAccount extends BankAccount {
	CurrentAccount(String name, double initialBal) throws InvalidInputException {
		super(name, initialBal);
	}
	
	@Override
	boolean isWithdrawalAllowed (double amt) {
		return true;
	}
}


//CHECKED EXCEPTION
class NotEnoughBalanceException extends Exception {
	public NotEnoughBalanceException(String message) {
		super(message);
	}
}

class InvalidInputException extends Exception {
	public InvalidInputException (String message) {
		super(message);
	}
}

public class BankTest {

	public static void main(String[] args) {
		
		try {
            BankAccount acc = new SavingsAccount("Adarsh", 1000);

            acc.deposit(2000);
            acc.withdraw(30);

            System.out.println("Balance: " + acc.getBalance());

        } catch (NotEnoughBalanceException | InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
		
	}
}
