package multiDimesional;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int[][] arr = new int[2][2];
		
		takeInput(arr);
		printOutput(arr);
	}
	
	public static void takeInput(int[][] arr) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr[0].length; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		input.close();
	}
	public static void printOutput(int[][] arr) {
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
	}
	
}
