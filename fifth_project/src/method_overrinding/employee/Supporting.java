package method_overrinding.employee;

public class Supporting extends Employee{
	double varPay = 100000;
	//
	public double SalCal(byte durationInMonth, float bonus) {
		return (((basePay+varPay)/12)*durationInMonth) + bonus;
	}
}
