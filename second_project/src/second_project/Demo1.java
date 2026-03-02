package second_project;

public class Demo1 {
	int i = 7;
	int k = m1();
	static int j = printer();
	int z = nonStaticMethod();
	
	static {
		System.out.println("Inside static1");
	}
	
	{
		System.out.println("From non static block()2");
	}
	public int nonStaticMethod() {
		System.out.println("from non static method()3");
		return 0;
	}
	public static void staticMethod() {	
		System.out.println("staticMethod");
	}
	public Demo1() {
		System.out.println("from constructor()4");
	}
	
	public static void main(String[] args) {
		System.out.println("Start of main");
		Demo1 demo = new Demo1(); // new is kw/operator creates object and return address 
		System.out.println(demo.k);
		System.out.println("End of main");
	}
	
	public static int printer() {
		System.out.println("printer is getting called5");
		return 0;
	}
	
	public int m1() {
		return 8;
	}
}
