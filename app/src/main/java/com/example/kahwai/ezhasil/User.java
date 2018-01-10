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

    public User(String email){
        this.email = email;
    }

    public User(String email, String name, String citizen, String sex, String dob, String phoneNo, String homePhoneNo, String icNo,
                String incomeTaxNo, String passportNo, String registeredPassport, String bankName, String bankAccountNo) {
        this.email = email;
        this.name = name;
        this.citizen = citizen;
        this.sex = sex;
        this.dob = dob;
        this.phoneNo = phoneNo;
        this.homePhoneNo = homePhoneNo;
        this.icNo = icNo;
        this.incomeTaxNo = incomeTaxNo;
        this.passportNo = passportNo;
        this.registeredPassport = registeredPassport;
        this.bankName = bankName;
        this.bankAccountNo = bankAccountNo;
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

}
