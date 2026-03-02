package has_a.bi;

public class Driver {
	public static void main(String[] args) {
		Car car = new Car();
		
		Engine e = new Engine();
		car.engine = e; // engine assigned to car
		e.car = car; //bidirectional  car assigned to engine
		
		System.out.println(car.col);
		System.out.println(car.engine);
		System.out.println(car.engine.noOfCyl);
		System.out.println(car.engine.car.col);
	}
}
