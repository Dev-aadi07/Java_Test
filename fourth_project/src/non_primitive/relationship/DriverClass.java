package non_primitive.relationship;

import java.util.Scanner;

public class DriverClass {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Car car = new Car();
		System.out.println("Which engine to fit? 1. Petrol and 2. Diesel");
		System.out.print("Enter your choice: ");
		byte userChoice = sc.nextByte();
		sc.nextLine();
		Engine engine = null; //container  not object
		switch(userChoice) {
		case 1: 
			engine = new PetrolEngine(); //upcasting
			break;
		case 2:
			engine = new DieselEngine(); //upcasted var
			break;
		default:
			engine = new PetrolEngine();
			break;
		}
		car.engine = engine;
		//Downcasting
		switch(userChoice) {
		case 1:
			PetrolEngine petrolEngine = (PetrolEngine) engine; //child petrolEngine = (child) parent engine
			petrolEngine.startEngine(); //using downcasted variable
			break;
		case 2:
			DieselEngine de = (DieselEngine) engine;
			de.startEngine();
			break;
		default:
			PetrolEngine p = (PetrolEngine)engine;
			p.startEngine();
			break;
		}
	}

}
