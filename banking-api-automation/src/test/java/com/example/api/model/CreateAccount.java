package com.example.api.model;

public class CreateAccount {
    public int accountNumber;
    public BankInformation bankInformation;
    public String accountStatus;
    public String accountType;
    public double accountBalance;
    public String accountCreated;

    public CreateAccount(int accountNumber, BankInformation bankInformation, String accountStatus, String accountType, double accountBalance, String accountCreated){
        this.accountNumber=accountNumber;
        this.bankInformation=bankInformation;
        this.accountStatus=accountStatus;
        this.accountType=accountType;
        this.accountBalance=accountBalance;
        this.accountCreated=accountCreated;
    }

}
