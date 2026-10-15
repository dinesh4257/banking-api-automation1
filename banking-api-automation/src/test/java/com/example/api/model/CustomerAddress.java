package com.example.api.model;

public class CustomerAddress {
    public String address1;
    public String address2;
    public String city;
    public String  state;
    public String   zip;
    public String country;

    public CustomerAddress( String address1, String address2,  String city,  String state, String zip, String country){
        this.address1=address1;
        this.address2=address2;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.country=country;

    }

}
