package encapsulation;

public class HalkuKaAcc {
	private double bal = 6000;
	private short pin = 6598;  //
	//
	public double getBal(short pin) {
		if (this.pin != pin) return -1;
		return this.bal;
	}
	//
	public void setBalCredit(double amt) {
		this.bal += amt;
	}
	public void setBalDebit(double amt) {
		this.bal -= amt;
	}
}
