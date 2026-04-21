package model;

import exceptions.InvalidAmountException;
import exceptions.InsufficientFundsException;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) throws InvalidAmountException {
        if(balance<0){
            throw new InvalidAmountException("Balance cannot be negative at first!");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if(amount<=0){
            throw new InvalidAmountException("Amount cannot be negative at first!");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if(amount<=0){
            throw new InvalidAmountException("Amount cannot be negative at first!");
        }
        if(amount>balance){
            throw new InsufficientFundsException("Not enough money in the account!");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "BankAccount: " + "accountNumber: " + accountNumber + ", ownerName: " + ownerName + ", balance: " + balance;
    }
}
