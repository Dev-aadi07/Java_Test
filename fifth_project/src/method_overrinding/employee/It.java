package method_overrinding.employee;

public class It extends Employee{
	double varPay = 200000;
	//
//	@Override
	public double SalCal(byte durationInMonth, float bonus) {
		return (((basePay+varPay)/12)*durationInMonth) + bonus;
	}
	//
}
