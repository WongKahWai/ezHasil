package com.example.kahwai.ezhasil;


/**
 * Created by Min on 10-Jan-18.
 */


public class User {
    //For login purpose
    public String email;

    //personal details
    public String name, citizen, sex, dob;

    //extra details
    public String phoneNo, homePhoneNo, icNo;
    public String incomeTaxNo, passportNo, registeredPassport;
    public String bankName, bankAccountNo;
    public String address, postcode, city, state;

    public User(String email){
        this.email = email;
    }

    public void setPersonalInfo(String name, String citizen, String sex, String dob, String incomeTaxNo){
        this.name = name;
        this.citizen = citizen;
        this.sex = sex;
        this.dob = dob;
        this.incomeTaxNo = incomeTaxNo;
    }

    //GETTERS
    public String getIcNo() {
        return icNo;
    }

    public String getName() {
        return name;
    }

    public String getCitizen() {
        return citizen;
    }

    public String getSex() {
        return sex;
    }

    public String getDob() {
        return dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getHomePhoneNo() {
        return homePhoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getIncomeTaxNo() {
        return incomeTaxNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public String getRegisteredPassport() {
        return registeredPassport;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }



    //SETTERS
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setHomePhoneNo(String homePhoneNo) {
        this.homePhoneNo = homePhoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public void setRegisteredPassport(String registeredPassport) { this.registeredPassport = registeredPassport; }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

}
