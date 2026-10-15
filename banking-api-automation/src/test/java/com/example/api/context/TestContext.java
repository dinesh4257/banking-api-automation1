package com.example.api.context;

import io.restassured.response.Response;
import java.math.BigDecimal;

public class TestContext {
    private Response response;
    private String customerNumber;
    private String accountNumber;
    private String destinationAccountNumber;
    private BigDecimal currentBalance;

    public Response getResponse() { return response; }
    public void setResponse(Response response) { this.response = response; }
    public String getCustomerNumber() { return customerNumber; }
    public void setCustomerNumber(String customerNumber) { this.customerNumber = customerNumber; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getDestinationAccountNumber() { return destinationAccountNumber; }
    public void setDestinationAccountNumber(String value) { this.destinationAccountNumber = value; }
    public BigDecimal getCurrentBalance() { return currentBalance; }
    public void setCurrentBalance(BigDecimal currentBalance) { this.currentBalance = currentBalance; }
    public void reset() { response = null; customerNumber = null; accountNumber = null; destinationAccountNumber = null; currentBalance = null; }
}
