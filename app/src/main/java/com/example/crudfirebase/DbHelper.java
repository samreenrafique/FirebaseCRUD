package com.example.crudfirebase;

public class DbHelper {
    String name, email, password, bcode;

    public DbHelper(){

    }
    public DbHelper(String name, String email, String password, String bcode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.bcode = bcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }
}
