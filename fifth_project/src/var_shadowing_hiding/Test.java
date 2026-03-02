package var_shadowing_hiding;

//variable Hiding
class Parent{
	int x = 10;
}

class Child extends Parent{
	int x = 200000;
}
public class Test {

	public static void main(String[] args) {
		Parent p = new Child(); //upcasting
		Child c = (Child) p; //downcasting
		System.out.println(p.x);
		System.out.println(c.x);
	}

}
