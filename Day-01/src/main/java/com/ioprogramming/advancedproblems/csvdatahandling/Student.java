package com.ioprogramming.advancedproblems.csvdatahandling;

public class Student {

    private int id;
    private String name;
    private String email;
    private double grade;

    public Student(int id, String name, String email, double grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', grade=" + grade + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
