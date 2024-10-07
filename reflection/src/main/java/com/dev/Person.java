package com.dev;

public class Person {
    private String firstName = "John";
    public String lastName = "Doe";

    public String getDefaultPerson() {
        return firstName + " " + lastName;
    }

    public String getPublicCustomPerson(String fname, String lname) {
        return fname + " " + lname;
    }

    public String getPrivateCustomPerson(String fname, int num) {
        return fname + num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
