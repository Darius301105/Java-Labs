package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) throws InvalidAmountException {
        super(accountNumber, ownerName, balance);
        if (interestRate < 0) {
            throw new InvalidAmountException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100.0;
        try {
            deposit(interest);
        } catch (InvalidAmountException e) {
            System.out.println("Error while adding interest: " + e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "SavingsAccount: " + "accountNumber: " + getAccountNumber() + ", ownerName: " + getOwnerName() + ", balance: " + getBalance() + ", interestRate: " + getInterestRate();
    }
}