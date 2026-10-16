package com.example.api.context;

import io.restassured.response.Response;


public class TestContext {
    private Response response;
    private String customerNumber;
    private String accountNumber;
    private String destinationAccountNumber;
    private int currentBalance;

    public Response getResponse() { return response; }
    public void setResponse(Response response) { this.response = response; }
    public String getCustomerNumber() { return customerNumber; }
    public void setCustomerNumber(String customerNumber) { this.customerNumber = customerNumber; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getDestinationAccountNumber() { return destinationAccountNumber; }
    public void setDestinationAccountNumber(String value) { this.destinationAccountNumber = value; }
    public int getCurrentBalance() { return currentBalance; }
    public void setCurrentBalance(int currentBalance) { this.currentBalance = currentBalance; }
    public void reset() { response = null; customerNumber = null; accountNumber = null; destinationAccountNumber = null; currentBalance = 0; }
}
