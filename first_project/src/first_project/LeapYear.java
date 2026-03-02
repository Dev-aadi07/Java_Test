package first_project;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter the no. of month(1-12): ");
		byte mon = userInput.nextByte();
		userInput.nextLine();
		int year;
		
		switch(mon) {
		case 2:
			System.out.print("Enter the year: ");
			year = userInput.nextInt();
			if ((year%4==0 && year%100!=0) || (year%400==0)) {
				System.out.println("29 days month");
			} else {
				System.out.println("28 days month");
			}
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31 days");
		}
	}
}
