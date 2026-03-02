package non_primitive.upcasting;

public class FamilyDriver {

	public static void main(String[] args) {
		Child c = new Child();
		Parent p = c; //Upcasting->generalization
		System.out.println(p.p);
		p.pm();
	}

}
