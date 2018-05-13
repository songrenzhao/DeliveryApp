package com.example.zhao.myapplication.Model;

public class User
{
    private String address;
    private String apt;
    private String name;
    private String email;
    private String password;

    public User()
    { }
    public User(String address, String apt, String email, String name, String password) {
        this.address = address;
        this.apt = apt;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public String getApt() {
        return apt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
