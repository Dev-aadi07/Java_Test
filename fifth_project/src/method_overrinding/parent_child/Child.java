package method_overrinding.parent_child;

import java.util.Scanner;

public class Child extends Parent{
	@Override  //not mandatory but convention 
	public void printStar() {
		System.out.println("Enter star count");
		Scanner sc = new Scanner(System.in);
		int starCount = sc.nextInt();
		sc.nextLine();
		sc.close();
		for (int i = 0; i<starCount; i++) {
			System.out.println("*");
		}
	}
}
