package com.example.api.steps;

import com.example.api.client.BankingApiClient;
import com.example.api.context.TestContext;
import com.example.api.model.*;
import com.example.api.util.*;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import java.util.UUID;

public class BankingSteps {
    private final TestContext context;
    private final BankingApiClient client = new BankingApiClient();
    int customerNumber;
    int accountNumber;
    int FromAccount;
    int ToAccount;
    int customerNum1;
    int customerNum2;

    public BankingSteps(TestContext context) { this.context = context; }


    @Given("a new customer")
    public void newCustomer(){
        String unique = UUID.randomUUID().toString().substring(0, 8);
        String firstName= commonUtilies.generateRandomString(7);
        String lastName= commonUtilies.generateRandomString(8);
        customerNumber=commonUtilies.generateRandomNumber(2000,3000);
        String status ="ACTIVE";
        String phoneNumber = String.valueOf((long)(Math.random() * 9000000000L) + 1000000000L);
        CustomerAddress customerAddress= new CustomerAddress("Star Park","Sus","Pune","Maharashtra","411021","India");
        ContactDetails contactDetails=new ContactDetails(lastName+"."+ firstName+ unique + "@example.com",phoneNumber,"String");
        Response res=client.addACustomer(new AddCustomer(firstName,lastName,commonUtilies.generateRandomString(4),customerNumber,status,customerAddress,contactDetails));
        res.then().log().all();
        context.setResponse(res);
    }

    // Only Return type has different
    public int createNewCustomer(){
        String unique = UUID.randomUUID().toString().substring(0, 8);
        String firstName= commonUtilies.generateRandomString(7);
        String lastName= commonUtilies.generateRandomString(8);
        customerNumber=commonUtilies.generateRandomNumber(1100,1800);
        String status ="Active";
        String phoneNumber = String.valueOf((long)(Math.random() * 9000000000L) + 1000000000L);
        CustomerAddress customerAddress= new CustomerAddress("Star Park","Sus","Pune","Maharashtra","411021","India");
        ContactDetails contactDetails=new ContactDetails(lastName+"."+ firstName+ unique + "@example.com",phoneNumber,"String");
        Response res=client.addACustomer(new AddCustomer(firstName,lastName,commonUtilies.generateRandomString(4),customerNumber,status,customerAddress,contactDetails));
        res.then().log().all();
        context.setResponse(res);
        return customerNumber;
    }

    public int newAccountRespectiveCustomer(int customerNumberVal){
        accountNumber=commonUtilies.generateRandomNumber(3000,5000);
        String []accountStatusArray={"Active"};
        String []accountTypeArray={"Saving"};
        String[] branchNameArray={"Mumbai"};
        String accountStatus=commonUtilies.selectRandomValueFromList(accountStatusArray,accountStatusArray.length);
        String accountType=commonUtilies.selectRandomValueFromList(accountTypeArray,accountTypeArray.length);
        String branchName=commonUtilies.selectRandomValueFromList(branchNameArray,branchNameArray.length);
        int branchCode=commonUtilies.generateRandomNumber(50);
        int routingNumber=commonUtilies.generateRandomNumber(9);
        double accountBalance=100;
        String accountCreated=commonUtilies.getDate();
        CustomerAddress bankAddress= new CustomerAddress("Living Park","Wakad","Pune","Maharashtra","411057","India");
        BankInformation bankInformation=new BankInformation(branchName,branchCode,bankAddress,routingNumber);
        Response res=client.AddNewAccount( customerNumberVal,new CreateAccount(accountNumber,bankInformation,accountStatus,accountType,accountBalance,accountCreated));
        res.then().log().all();
        context.setResponse(res);
        return accountNumber;
    }

    @Given("Two new customer and it respective account")
    public void twoCustomerAndAccountCreate(){
        customerNum1= createNewCustomer();
        customerNum2= createNewCustomer();
        FromAccount=newAccountRespectiveCustomer(customerNum1);
        ToAccount=newAccountRespectiveCustomer(customerNum2);

    }


    @Given("a new customerNumber mapped to Account Number")
    public void newAccountForCustomer(){
        accountNumber=commonUtilies.generateRandomNumber(6000,2001);
        String []accountStatusArray={"Active", "Inactive","Open"};
        String []accountTypeArray={"Saving","Current"};
        String[] branchNameArray={"Pune","Mumbai","Chennai"};
        String accountStatus=commonUtilies.selectRandomValueFromList(accountStatusArray,accountStatusArray.length);
        String accountType=commonUtilies.selectRandomValueFromList(accountTypeArray,accountTypeArray.length);
        String branchName=commonUtilies.selectRandomValueFromList(branchNameArray,branchNameArray.length);
        int branchCode=commonUtilies.generateRandomNumber(50);
        int routingNumber=commonUtilies.generateRandomNumber(9);
        double accountBalance=commonUtilies.generateRandomNumber(9999);
        String accountCreated=commonUtilies.getDate();
        CustomerAddress bankAddress= new CustomerAddress("Living Park","Wakad","Pune","Maharashtra","411057","India");
        BankInformation bankInformation=new BankInformation(branchName,branchCode,bankAddress,routingNumber);
        Response res=client.AddNewAccount( this.customerNumber,new CreateAccount(accountNumber,bankInformation,accountStatus,accountType,accountBalance,accountCreated));
        res.then().log().all();
        context.setResponse(res);
    }


    @When("I update the customer")
    public void updateCustomer() {
        String unique = UUID.randomUUID().toString().substring(0, 8);
        String firstName= commonUtilies.generateRandomString(7);
        String lastName= commonUtilies.generateRandomString(8);
        //customerNumber=commonUtilies.generateRandomNumber(99);
        String[] statusArray={"Single", "Married"};
        String status =commonUtilies.selectRandomValueFromList(statusArray,statusArray.length);
        String phoneNumber = String.valueOf((long)(Math.random() * 9000000000L) + 1000000000L);
        CustomerAddress customerAddress= new CustomerAddress("Star Park","Sus","Pune","Maharashtra","411021","India");
        ContactDetails contactDetails=new ContactDetails(lastName+"."+ firstName+ unique + "@example.com",phoneNumber,"String");
        Response res=client.updateCustomer(this.customerNumber,new AddCustomer(firstName,lastName,commonUtilies.generateRandomString(4),this.customerNumber,status,customerAddress,contactDetails));
        res.then().log().all();
        context.setResponse(res);
    }

    @When("Get Account Number detail")
    public void getAccount() {
        Response res=client.getAccount(this.accountNumber);
        res.then().log().all();
        context.setResponse(res);
    }

    @When("Get Non Account Number detail")
    public void getNonExistAccount() {
        Response res=client.getAccount(commonUtilies.generateRandomNumber(10000,15000));
        res.then().log().all();
        context.setResponse(res);
    }

    @When("Get the customer")
    public void getCustomer() {
        Response res=client.getCustomer(this.customerNumber);
        res.then().log().all();
        context.setResponse(res);
    }

    @When("Get All Customer Details")
    public void GetAllCustomer(){
        Response res=client.getAllCustomer();
        res.then().log().all();
        context.setResponse(res);
    }

    @When("Delete Customer Details")
    public void deleteCustomer() {
        Response res=client.deleteCustomer(this.customerNumber);
        res.then().log().all();
        context.setResponse(res);
    }

    @When("User transfer {int} from the created account")
    public void transfer(int amount) {
        TransferRequest transferRequest=new TransferRequest(FromAccount,ToAccount,amount);

        Response res=client.transfer(this.customerNum1,transferRequest);
        res.then().log().all();
        context.setResponse(res);
    }

    @When("Get all transaction for respective account number")
    public void getAllTransaction() {
        Response res1=client.getAllTransactions(this.FromAccount);
        res1.then().log().all();
        context.setResponse(res1);

        Response res=client.getAllTransactions(this.ToAccount);
        res.then().log().all();
        context.setResponse(res);

    }
    @When("I attempt to transfer more than the current balance")
    public void transferMoreThanBalance() {
        int amount = 9999;
        context.setResponse(client.transfer(this.customerNum1,new TransferRequest(FromAccount,ToAccount,amount)));
    }

    @Then("the response status should be {int}")
    public void verifyStatus(int status) {
        Assertions.assertEquals(status, context.getResponse().statusCode(), context.getResponse().asPrettyString());
    }

    @Then("the transfer status should be {string}")
    public void verifyTransferStatus(String expected) {
        Assertions.assertEquals(expected, context.getResponse().jsonPath().getString("Success"));
    }

    @Then("the error code should be {string}")
    public void verifyErrorCode(String expected) {
        Assertions.assertEquals(expected, context.getResponse().jsonPath().getString("error.code"));
    }
}
