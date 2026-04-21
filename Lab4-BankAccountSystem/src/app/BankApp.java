package app;

import exceptions.InvalidAmountException;
import exceptions.InsufficientFundsException;
import model.BankAccount;
import model.SavingsAccount;

public class BankApp {
    public static void main(String[] args) {
        try{
            BankAccount baccount1 = new BankAccount("RO001", "Emil", 1000);
            SavingsAccount baccount2 = new SavingsAccount("RO002", "Dumitru", 10000, 5);

            System.out.println("\nAccounts created:");
            System.out.println(baccount1);
            System.out.println(baccount2);

            System.out.println("\nDeposit:");
            baccount1.deposit(500);
            System.out.println("After deposit: " + baccount1);

            System.out.println("\nWithdraw:");
            baccount1.withdraw(300);
            System.out.println("After withdraw: " + baccount1);

            System.out.println("\nAdd interest to savings account:");
            baccount2.addInterest();
            System.out.println(baccount2);

            System.out.println("\nInvalid deposit test:");
            baccount1.deposit(-100);
        } catch (InvalidAmountException e) {
            System.out.println("InvalidAmountException: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("InsufficientFundsException: " + e.getMessage());
        }

        try {
            BankAccount account3 = new BankAccount("RO003", "Maria", 400);
            System.out.println("\nInsufficient funds test:");
            account3.withdraw(1000);
        } catch (InvalidAmountException e) {
            System.out.println("InvalidAmountException: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("InsufficientFundsException: " + e.getMessage());
        }

        try {
            System.out.println("\nInvalid initial balance test:");
            BankAccount account4 = new BankAccount("RO004", "George", -50);
            System.out.println(account4);
        } catch (InvalidAmountException e) {
            System.out.println("InvalidAmountException: " + e.getMessage());
        }
    }
}
