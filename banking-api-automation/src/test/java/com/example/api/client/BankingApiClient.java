package com.example.api.client;

import com.example.api.config.RequestSpecFactory;
import com.example.api.model.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BankingApiClient {


    public Response addACustomer(AddCustomer body) {
        return given().spec(RequestSpecFactory.create()).body(body).when().post("customers/add");
    }

    public Response AddNewAccount(int customerNumber,CreateAccount body){
        return given().spec(RequestSpecFactory.create()).pathParam("customerNumber", customerNumber)
                .body(body).when().post("/accounts/add/{customerNumber}");
    }

    public Response getCustomer(int customerNumber) {
        return given().spec(RequestSpecFactory.create()).pathParam("customerNumber", customerNumber)
                .when().get("/customers/{customerNumber}");
    }

    public Response getAllCustomer() {
        return given().spec(RequestSpecFactory.create())
                .when().get("/customers/all");
    }

    public Response getAccount(int accountNumber) {
        return given().spec(RequestSpecFactory.create()).pathParam("accountNumber", accountNumber)
                .when().get("/accounts/{accountNumber}");
    }
    public Response getAllTransactions(int accountNumber) {
        return given().spec(RequestSpecFactory.create()).pathParam("accountNumber", accountNumber)
                .when().get("/accounts/transactions/{accountNumber}");
    }
    public Response updateCustomer(int customerNumber, AddCustomer body) {
        return given().spec(RequestSpecFactory.create()).pathParam("customerNumber", customerNumber)
                .body(body).when().put("/customers/{customerNumber}");
    }
    public Response deleteCustomer(int customerNumber) {
        return given().spec(RequestSpecFactory.create()).pathParam("customerNumber", customerNumber)
                .when().delete("/customers/{customerNumber}");
    }
    public Response transfer(int customerNumber,TransferRequest body) {
        return given().spec(RequestSpecFactory.create()).pathParam("customerNumber", customerNumber).body(body).when().put("/accounts/transfer/{customerNumber}");
    }
}
