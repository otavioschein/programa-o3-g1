package entities;

import enums.Status;

import java.util.ArrayList;
import java.util.Date;

public class Customer {

    private String cpf;
    private String name;
    private String phoneNumber;
    private String email;
    private Date birthday;
    private String gender;
    private String maritalStatus;
    private Status status;
    private Address address;
    
    public static ArrayList<Service> serviceListForCustomer = new ArrayList<Service>();

    public Customer(String cpf, String name, String phoneNumber, String email, Date birthday, String gender, String maritalStatus, Status status, Address address) {
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.status = status;
        this.address = address;
    }
    
    public Customer(){
    	
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
