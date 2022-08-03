package day2;

import java.util.Scanner;

public class BankAccount {
    private int balance;
    private int previousTransaction;
    private String customerName;
    private static int Id = 0;
    private int customerId = 0;

    BankAccount(String cname) {
        customerName = cname;
        Id += 1;
        customerId = Id;
    }

    public void deposit(int amount) {

        if (amount != 0 && amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;
        } else {
            System.out.println("The amount " + amount + " is not a valid amount.");
        }
    }

    public void withdraw(int amount) {
        if (amount != 0 && amount > 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        } else {
            System.out.println("The amount " + amount + " is not a valid amount.");
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    public void showId() {
        System.out.println("Hi " + customerName + " your ID is: " + customerId);
    }

    public void showOptions() {
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
    }

    public void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);

        do {
            showOptions();
            System.out.println("===========================================================================");
            System.out.println("Enter an option");
            System.out.println("===========================================================================");
            option = sc.next().toLowerCase().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'a':
                    System.out.println("Check Balance");
                    System.out.println("-----------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("-----------------------------------");
                    System.out.println("\n");
                    break;

                case 'b':
                    while (true) {
                        System.out.println("Deposit");
                        System.out.println("-----------------------------------");
                        System.out.println("Enter an amount to deposit:");
                        System.out.println("-----------------------------------");
                        try {
                            int amount = sc.nextInt();
                            deposit(amount);
                            System.out.println("\n");
                            break;
                        } catch (Exception e) {
                            System.out.println("The value entered is not a number. Please enter a valid number.");
                            sc.nextLine();
                            System.out.println("\n");
                        }
                    }
                    break;

                case 'c':
                    while (true) {
                        System.out.println("Withdraw");
                        System.out.println("-----------------------------------");
                        System.out.println("Enter an amount to withdraw:");
                        System.out.println("-----------------------------------");
                        try {
                            int amountTwo = sc.nextInt();
                            withdraw(amountTwo);
                            System.out.println("\n");
                            break;
                        } catch (Exception e) {
                            System.out.println("The value entered is not a number. Please enter a valid number.");
                            sc.nextLine();
                            System.out.println("\n");
                        }
                    }
                    break;

                case 'd':
                    System.out.println("Getting most recent transaction");
                    System.out.println("-----------------------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------------------");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("*******************************************************");
                    break;

                default:
                    System.out.println("Invalid Option!! Please enter again.");
                    break;
            }

        } while (option != 'e');

        System.out.println("Thank you for using our services!");
    }
}
