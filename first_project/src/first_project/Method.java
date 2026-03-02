package first_project;

public class Method {
	public static void main(String[] args) {
		System.out.println("Start of main");
		m1(); // static method
		Method.m1();
		System.out.println("End of main");
	}
	
	public static void m1() {
		System.out.println("From m1()");
	}
}
