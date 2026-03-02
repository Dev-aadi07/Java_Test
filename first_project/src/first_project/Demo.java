package first_project;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		//
		System.out.print("Enter 3 digit num: ");
		short num = userInput.nextShort();		
		System.out.println("num: "+ num);
		
		userInput.nextLine();
		
		System.out.print("Name: ");
		String name = userInput.nextLine();
		
		System.out.println("name: "+name);
	}
}
