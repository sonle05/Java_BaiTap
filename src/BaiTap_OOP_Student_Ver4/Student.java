package BaiTap_OOP_Student_Ver4;

import java.util.Date;

public class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    // Getters and Setters
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        // Logic to add a student
    }

    @Override
    public void updatePerson(String id) {
        // Logic to update a student by ID
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getFormattedDateOfBirth());
        System.out.println("GPA: " + getGpa());
        System.out.println("Major: " + getMajor());
    }
}
