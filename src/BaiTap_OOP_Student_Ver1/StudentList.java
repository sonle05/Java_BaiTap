package BaiTap_OOP_Student_Ver1;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class StudentList {
    private ArrayList<Student> studentList;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public StudentList() {
        studentList = new ArrayList<>();
    }

    // Method to add a new student
    public void addStudent() throws ParseException {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter date of birth (dd/MM/yyyy): ");
        Date dob = sdf.parse(scanner.nextLine());

        System.out.print("Enter GPA: ");
        float gpa = scanner.nextFloat();
        scanner.nextLine(); // consume newline

        System.out.print("Enter major: ");
        String major = scanner.nextLine();

        Student student = new Student(id, fullName, dob, gpa, major);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    // Method to update a student by id
    public void updateStudentById() throws ParseException {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();

        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter new date of birth (dd/MM/yyyy): ");
            Date dob = sdf.parse(scanner.nextLine());

            System.out.print("Enter new GPA: ");
            float gpa = scanner.nextFloat();
            scanner.nextLine(); // consume newline

            System.out.print("Enter new major: ");
            String major = scanner.nextLine();

            student.setFullName(fullName);
            student.setDateOfBirth(dob);
            student.setGpa(gpa);
            student.setMajor(major);
            System.out.println("Student with ID " + id + " updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to delete a student by id
    public void deleteStudentById() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();

        Student student = findStudentById(id);
        if (student != null) {
            studentList.remove(student);
            System.out.println("Student with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to find a student by id
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Method to display all students
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : studentList) {
                student.displayInfo();
                System.out.println("-------------");
            }
        }
    }

    // Method to find the student with the highest GPA
    public void findTopStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        System.out.println("Top student:");
        topStudent.displayInfo();
    }
}
