package com.solerabootcamp.bankdev.user;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;

    private List<Integer> bankAccounts;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(int id, String firstName, String lastName, String username, String password, String email, String phone) {
        this.id = id;
        this.bankAccounts = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<Integer> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
