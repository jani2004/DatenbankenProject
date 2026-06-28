package org.example.datenbankenprojekt.model;

public class Employee {

    private int socNum;
    private int empNum;
    private String firstName;
    private String lastName;

    public Employee(int socNum, int empNum, String firstName, String lastName) {
        this.socNum = socNum;
        this.empNum = empNum;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getSocNum() {
        return socNum;
    }

    public int getEmpNum() {
        return empNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}