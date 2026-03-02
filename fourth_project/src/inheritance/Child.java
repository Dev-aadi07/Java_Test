package inheritance;

public class Child extends Parent{
	int c = 3;
//	showP(); //why not??
	protected void showC() {
		System.out.println("This is Childe");
	}
}
