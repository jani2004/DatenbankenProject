package org.example.datenbankenprojekt.model;

public class BankAccount {

    private int bankNum;
    private int accountNum;
    private int balance;

    public BankAccount(int bankNum, int accountNum, int balance) {
        this.bankNum = bankNum;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public int getBankNum() {
        return bankNum;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getBalance() {
        return balance;
    }
}