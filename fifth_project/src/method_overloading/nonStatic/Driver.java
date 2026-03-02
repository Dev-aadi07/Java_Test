package method_overloading.nonStatic;

public class Driver {

	public static void main(String[] args) {
		Child ch = new Child();
		ch.printNum(7); //inherited 
		ch.printNum(4, 3); //overloaded

		Parent p = new Parent();
		p.printNum(9000);

	}

}
