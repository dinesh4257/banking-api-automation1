package com.example.api.model;

public class AddCustomer {
    public String firstName;
    public String lastName;
    public String middleName;
    public int customerNumber;
    public String status;
    public CustomerAddress customerAddress;
    public ContactDetails contactDetails;

    public AddCustomer(String firstName,String lastName,String middleName,int customerNumber,String status,CustomerAddress customerAddress ,ContactDetails contactDetails){
        this.firstName=firstName;
        this.lastName=lastName;
        this.middleName=middleName;
        this.customerNumber=customerNumber;
        this.status=status;
        this.customerAddress=customerAddress;
        this.contactDetails=contactDetails;
    }

}
