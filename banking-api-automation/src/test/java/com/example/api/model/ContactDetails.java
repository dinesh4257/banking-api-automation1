package com.example.api.model;

public class ContactDetails {
    public String emailId;
    public String homePhone;
    public String workPhone;

    public ContactDetails(String emailId,String homePhone, String workPhone){
        this.emailId=emailId;
        this.homePhone=homePhone;
        this.workPhone=workPhone;
    }
}
