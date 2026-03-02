package non_primitive.downcasting;

public class FamilyDriver {

	public static void main(String[] args) {
		Child c = new Child();
		Parent p = c; //Upcasting->generalization
		System.out.println(p.p);
		p.pm();
		
		// Downcasting-->specialization
		Parent pp = new Parent();
		Child ch = (Child) pp; //will get issue--> classCast EXCEPTION
		
		//use Upcasted parent var --> specialization
		Child downCastedChildVar = (Child) p;
	}

}
