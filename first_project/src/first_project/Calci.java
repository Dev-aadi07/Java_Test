package first_project;

import java.util.*;

public class Calci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int flag = 1;
		int num1, num2;
		char op;
		
		while (flag==1) {
			System.out.println("=========Calculator=========");
			System.out.print("Enter first num: ");
			num1 = input.nextInt();
			//
			System.out.print("Enter the operator(+,-,*,/): ");
			op = input.next().charAt(0);
			//
			System.out.print("Enter the second num: ");
			num2 = input.nextInt();
			calc(num1, op, num2);
			
			System.out.print("Do you want to continue(0/1)?: ");
			flag = input.nextInt();
		}
	}
	public static void calc(int a,char op, int b) {
		switch(op) {
		case'+': add(a,b); break;
		case'-': sub(a,b); break;
		case'*': mul(a,b); break;
		case'/': div(a,b); break;
		default: System.out.println("Invalid input");
		}
	}
	
	public static void add(int a, int b) {
		System.out.println(a+b);
	}
	public static void sub(int a, int b) {
		System.out.println(a-b);
	}
	public static void mul(int a, int b) {
		System.out.println(a*b);
	}
	public static void div(int a, int b) {
		System.out.println(a/b);
	}
}
