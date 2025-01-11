package simplebankingapplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleBankingApplication {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Simple Banking Application!");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter an initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Set a 4-digit PIN: ");
        String pin = scanner.nextLine();

        String accountNumber = "AC" + (accounts.size() + 1);
        Account account = new Account(accountNumber, name, initialDeposit, pin);
        accounts.put(accountNumber, account);

        System.out.println("Account created successfully! Your account number is " + accountNumber);
    }

    private static void login() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();

            Account account = accounts.get(accountNumber);

            if (account.validatePin(pin)) {
                System.out.println("Login successful! Welcome, " + account.getAccountHolderName() + ".");
                accountMenu(account);
            } else {
                System.out.println("Invalid PIN. Login failed.");
            }
        } else {
            System.out.println("Account not found. Please try again.");
        }
    }

    private static void accountMenu(Account account) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    logout = true;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}