package com.example.api.model;



public class TransferRequest {
    public int fromAccountNumber;
    public int toAccountNumber;
    public int transferAmount;

    
    public TransferRequest(int from, int to, int transferAmount) {
        this.fromAccountNumber = from;
        this.toAccountNumber = to;
        this.transferAmount = transferAmount;
    }
}
