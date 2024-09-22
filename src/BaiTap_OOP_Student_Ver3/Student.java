package BaiTap_OOP_Student_Ver3;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {
    private float gpa;
    private String major;
    private Scanner scanner = new Scanner(System.in);

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

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

    public void addStudent(){
    }
    
    public void updateStudent(String id){
        this.setFullName(super.getFullName());
        this.setDateOfBirth(super.getDateOfBirth());
        this.gpa = gpa;
        this.major = major;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getFormattedDateOfBirth());
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }
}
