package method_overloading;

public class StaticMethodOverloading {
	public static void add() {
		//base1
	}
	public static void add(double op1, double o2) {
		//no of args
		// base2 (compare with base1)
	}
	public static void add(float op1, double op2) {
		//change in DT of args
		//base3 (compare it with base2)
	}
	public static void add(double op1, float op2) {
		//change in order of DT in args
		//base4 (compare it with base)
	}
	
	public static void add(double op1, char opr, double op2) {
		//change in no. of arg, DT of args, order of DT in args
		//base5 (compare it with base4)
	}
	public void sub() {
		
	}
}
