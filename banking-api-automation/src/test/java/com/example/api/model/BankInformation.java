package com.example.api.model;

public class BankInformation {
    public String branchName;
    public int branchCode;
    public CustomerAddress branchAddress;
    public int routingNumber;

    public BankInformation(String branchName, int branchCode, CustomerAddress branchAddress, int routingNumber){
        this.branchName=branchName;
        this.branchCode=branchCode;
        this.branchAddress=branchAddress;
        this.routingNumber=routingNumber;
    }
}
