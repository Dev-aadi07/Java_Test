package has_a.uni;

public class Driver {
	public static void main(String[] args) {
		Engine e = new Engine();
		Car c = new Car();
		c.engine = e; // fixing engine inside car
		
		System.out.println(c.col);
		System.out.println(c.engine.noOfCyl);
	}
}
