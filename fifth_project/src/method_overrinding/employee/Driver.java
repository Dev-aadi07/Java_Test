package method_overrinding.employee;

public class Driver {

	public static void main(String[] args) {
		It a = new It();
		System.out.println(a.SalCal((byte)1, 0));
		
		Supporting s = new Supporting();
		System.out.println(s.SalCal((byte)1, 0));
	}
}
