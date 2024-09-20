package BaiTap_OOP_Student_Ver1;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person implements IPerson {
    private float gpa;
    private String major;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor
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

    // Override displayInfo to show date in dd/MM/yyyy format
    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }
}
