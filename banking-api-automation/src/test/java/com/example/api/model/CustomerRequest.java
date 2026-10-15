package com.example.api.model;

public class CustomerRequest {
    public String firstName;
    public String lastName;
    public String email;
    public String phone;


    public CustomerRequest(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName; this.lastName = lastName; this.email = email; this.phone = phone;
    }
}
