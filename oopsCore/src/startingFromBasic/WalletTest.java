package startingFromBasic;

abstract class DigitalWallet {
	private String user;
	private double balance;
	
	DigitalWallet(String name, double initialBalance) throws InvalidInputException {
		
		this.user = name;
		
		if (initialBalance < 0) throw new InvalidInputException("Initial amount must be positive.");
		
		this.balance = initialBalance;
	}
	
	void addMoney(double amt) throws InvalidInputException{
		if (amt <=0 ) throw new InvalidInputException("Amount to add must be positive.");
		balance += amt;
	}
	
	
	abstract boolean isPaymentAllowed(double amt) throws NotEnoughBalanceException, ExceedingLimitException;
	
	void pay(double amt) throws InvalidInputException, NotEnoughBalanceException, ExceedingLimitException {
		
		if (amt<=0) throw new InvalidInputException("You need to put amount to pay.");
		if (!isPaymentAllowed(amt)) throw new ExceedingLimitException("Payment amount must be less than 5000");
		
		balance -= amt;
		
	}
	
	double getBalance() {
		return balance;
	}
	
	void show() {
		System.out.println("User: "+user);
		System.out.println("Balance: "+balance);
	}
}

// Basic Wallet
class BasicWallet extends DigitalWallet {
	BasicWallet(String name, double balance) throws InvalidInputException{
		super(name, balance);
	}
	
	@Override
	boolean isPaymentAllowed(double amt) throws NotEnoughBalanceException, ExceedingLimitException {
		final double LIMIT = 5000;
		if (amt > getBalance()) throw new NotEnoughBalanceException("Not sufficient balance in wallet.");
		if (amt > LIMIT) throw new ExceedingLimitException("Maximum payment per transaction for this wallet is: "+LIMIT);
		return true;
	}
}

// Premium Wallet
class PremiumWallet extends DigitalWallet {
	PremiumWallet(String name, double balance) throws InvalidInputException{
		super(name, balance);
	}
	
	@Override
	boolean isPaymentAllowed(double amt) throws NotEnoughBalanceException{
		if (amt > getBalance()) throw new NotEnoughBalanceException("Not sufficient balance in wallet.");
		return true;
	}
}


public class WalletTest {

	public static void main(String[] args) {
		try {
			DigitalWallet dw = new BasicWallet("Aadi", 10000);
			DigitalWallet dww = new PremiumWallet("Aadarsh", 50000);
			
			try {
				dw.pay(5000);
				dww.pay(5002);
			} catch (ExceedingLimitException e) {
				System.out.println(e.getMessage());
			}
			dw.show();
			dww.show();
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (NotEnoughBalanceException e) {
			System.out.println(e.getMessage());
		}
	}

}

//CHECKED EXCEPTION
class InvalidInputException extends Exception {
	public InvalidInputException(String m) {
		super(m);
	}
}

class NotEnoughBalanceException extends Exception {
	public NotEnoughBalanceException(String m) {
		super(m);
	}
}

class ExceedingLimitException extends Exception {
	public ExceedingLimitException(String m) {
		super(m);
	}
}