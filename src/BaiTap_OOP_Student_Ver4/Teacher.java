package BaiTap_OOP_Student_Ver4;

import java.util.Date;

public class Teacher extends Person {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    // Getters and Setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void addPerson() {
        // Logic to add a teacher
    }

    @Override
    public void updatePerson(String id) {
        // Logic to update a teacher by ID
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getFormattedDateOfBirth());
        System.out.println("Department: " + getDepartment());
        System.out.println("Teaching Subject: " + getTeachingSubject());
    }
}
