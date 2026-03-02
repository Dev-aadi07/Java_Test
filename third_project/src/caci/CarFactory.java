package caci;

import java.util.Scanner;

public class CarFactory {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Car car = new Car();
		System.out.println("Which Engine? 1. Petrol 2. Diesel: ");
		Byte userChoice = userInput.nextByte();
		userInput.nextLine();
		Engine e = null;
		switch (userChoice) {
		case 1: {
			PetrolEngine pe = new PetrolEngine();
			e = pe;
			break;
		}
		case 2: {
			DieselEngine de = new DieselEngine();
			e = de;
			break;
		}
		default:
			PetrolEngine pe1 = new PetrolEngine();
			e = pe1;
			break;
		}
	
		car.engine = e;
		System.out.println("Engine in Car: "+car.engine);
	}
}
