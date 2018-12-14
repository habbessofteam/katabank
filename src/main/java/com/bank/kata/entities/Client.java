package com.bank.kata.entities;

public class Client {

    private Double id;

    private String firstName;

    private String lastName;

    public Client() {
        this.id = (Double) Math.random() * 123 + 1;
    }

    public Client(String firstName, String lastName) {
        this.id = (Double) Math.random() * 123 + 1;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Double getId() {
        return id;
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
}
