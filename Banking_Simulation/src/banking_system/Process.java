package banking_system;

import java.util.Scanner;
import banking_system.exception.InvalidAmountException;

public class Process {

    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public void startProcess() {
        try {
            createAccount();
            menuLoop();
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void createAccount() throws InvalidAmountException {

        int choice = 0;

        while (true) {
        	System.out.println("Choose account to create");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.print("Choose account type: ");

            choice = sc.nextInt();

            if (choice == 1 || choice == 2) {
                break;
            } else {
                System.out.println("Invalid Input\n");
            }
        }

        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Set 4-digit PIN: ");
        int pin = sc.nextInt();

        if (choice == 1) {
            account = new SavingsAccount("SAV123", name, balance, pin);
        } else {
            account = new CurrentAccount("CUR123", name, balance, pin);
        }

        System.out.println("\nAccount created successfully!");
    }

    private void menuLoop() {
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\n----- MENU -----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose: ");

                int option = sc.nextInt();

                switch (option) {

                    case 1:
                        if (verifyPin()) {
                            System.out.println("Balance: " + account.getBalance());
                        }
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;

                    case 3:
                        if (verifyPin()) {
                            System.out.print("Enter withdraw amount: ");
                            double amt = sc.nextDouble();
                            account.withdraw(amt);
                        }
                        break;

                    case 4:
                        exit = true;
                        System.out.println("Thank you for banking with us!");
                        break;

                    default:
                        System.out.println("Invalid option");
                }

            } catch (Exception e) {
                System.out.println("Transaction failed: " + e.getMessage());
                sc.nextLine(); 
            }
        }
    }

    private boolean verifyPin() {
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!account.validatePin(enteredPin)) {
            System.out.println("Incorrect PIN!");
            return false;
        }
        return true;
    }
}
