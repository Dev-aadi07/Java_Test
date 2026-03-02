package method_overrinding.employee;

public class Employee {
	double basePay = 300000;
	//
	
	public double SalCal(byte durationInMonth) {
		return ((basePay/12)*durationInMonth);
	}
}
