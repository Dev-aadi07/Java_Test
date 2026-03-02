package second_project;

public class Demo {
	
	static int i = printer();
	
	public static void main(String[] args) {
		System.out.println("Start of main");
		System.out.println("End of main");
	}
	
	static {
		System.out.println("from static block2");
		main(null); 
	}
	
	public static int printer() {
		System.out.println("Printed by printer");
		return 0;
	}
}
