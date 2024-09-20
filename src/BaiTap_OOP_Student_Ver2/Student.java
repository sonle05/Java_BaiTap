package BaiTap_OOP_Student_Ver2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {
    private float gpa;
    private String major;
    private boolean scholarship; // Cờ để đánh dấu sinh viên có học bổng
    private double tuition;

    private final double BASE_TUITION = 10000000; // Học phí cơ bản là 10 triệu

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.scholarship = isScholarship(); // Xác định sinh viên có học bổng ngay khi khởi tạo
        this.tuition = calculateTuition();
    }

    // Getter và Setter cho các thuộc tính
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.scholarship = isScholarship(); // Cập nhật học bổng khi GPA thay đổi
        this.tuition = calculateTuition();  // Cập nhật lại học phí khi GPA thay đổi
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isScholarship() {
        return this.gpa >= 9.0;  // Điều kiện học bổng: GPA >= 9
    }

    public double calculateTuition() {
        if (isScholarship()) {
            return BASE_TUITION * 0.5; // Giảm 50% học phí nếu có học bổng
        } else {
            return BASE_TUITION;
        }
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Tuition: " + tuition);
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
    }
}
