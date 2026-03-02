package first_project;

import java.util.Scanner;

public class Calculator {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.print("Enter operator (+, -, *, /): ");
            char operator = input.next().charAt(0);

            System.out.print("How many numbers? ");
            int n = input.nextInt();

            double[] nums = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                nums[i] = input.nextDouble();
            }

            switch (operator) {
                case '+':
                    System.out.println(addition(nums));
                    break;
                case '-':
                    System.out.println(subtraction(nums));
                    break;
                case '*':
                    System.out.println(multiplication(nums));
                    break;
                case '/':
                    System.out.println(division(nums));
                    break;
                default:
                    System.out.println("Invalid operator");
            }

            toContinue();
        } while (true);
    }

    public static void toContinue() {
        System.out.print("To continue enter 'y': ");
        char selection = input.next().charAt(0);
        if (selection != 'y') {
            System.out.println("---------EXIT----------");
            System.exit(0);
        }
    }

    public static double addition(double... nums) {
        double sum = 0;
        for (double n : nums) sum += n;
        return sum;
    }

    public static double subtraction(double... nums) {
        double result = nums[0];
        for (int i = 1; i < nums.length; i++) result -= nums[i];
        return result;
    }

    public static double multiplication(double... nums) {
        double result = 1;
        for (double n : nums) result *= n;
        return result;
    }

    public static double division(double... nums) {
        double result = nums[0];
        for (int i = 1; i < nums.length; i++) result /= nums[i];
        return result;
    }
}
