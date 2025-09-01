package week3.lab;

import java.util.Scanner;

class BankAccount {
    private static int accountCounter = 1;
    private static int totalAccounts = 0;

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String name, double initialDeposit) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = name.trim(); // using String method
        this.balance = initialDeposit;
        totalAccounts++;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", accountCounter++);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw must be positive.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + " | Holder: " + accountHolderName + " | Balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1000);
        BankAccount acc2 = new BankAccount("Bob", 2000);

        acc1.deposit(500);
        try {
            acc2.withdraw(3000); // triggers exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
