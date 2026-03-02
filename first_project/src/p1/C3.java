package p1;

import java.util.Scanner;

public class C3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 to stop.");
        int sum = 0;
        while(true) {
        	int temp = sc.nextInt();
        	sum+=temp;
        	if(temp==0) break;
        }

        System.out.println("Sum: " + sum);
        sc.close();
    }

//    public static int add(int... numbers) {
//        int sum = 0;
//        for (int n : numbers) {
//            sum += n;
//        }
//        return sum;
//    }
}
