package com.businessgame.model;

import static com.businessgame.constant.BusinessConstant.BANK_INITIAL_CAPITAL;

public class Bank extends Party{

    private int id;
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Bank(int balance) {
        this.balance = balance;
    }

    public static Bank initializeBankWithCapital(){
       return new Bank(BANK_INITIAL_CAPITAL);
    }
}
