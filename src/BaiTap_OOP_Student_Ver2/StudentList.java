package BaiTap_OOP_Student_Ver2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentList {

    private ArrayList<Student> studentList;
    private Scanner scanner;
    private SimpleDateFormat sdf;

    public StudentList() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void addStudent() {
        try {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Enter Full Name: ");
            String fullName = scanner.nextLine();
            
            System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
            Date dateOfBirth = sdf.parse(scanner.nextLine());
            
            System.out.print("Enter GPA: ");
            float gpa = scanner.nextFloat();
            
            scanner.nextLine();
            
            System.out.print("Enter Major: ");
            String major = scanner.next();
            
            Student newStudent = new Student(id, fullName, dateOfBirth, gpa, major);
            studentList.add(newStudent);
            System.out.println("Student added successfully!");
            
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd/MM/yyyy.");
        }
    }

    public void updateStudentById() {
        System.out.print("Enter ID to update: ");
        String updateId = scanner.nextLine();
        Student studentToUpdate = findStudentById(updateId);
        if (studentToUpdate != null) {
            System.out.print("Enter new Full Name: ");
            studentToUpdate.setFullName(scanner.nextLine());
            System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
            try {
                Date newDateOfBirth = sdf.parse(scanner.nextLine());
                studentToUpdate.setDateOfBirth(newDateOfBirth);
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please use dd/MM/yyyy.");
            }
            System.out.print("Enter new GPA: ");
            studentToUpdate.setGpa(scanner.nextFloat());
            System.out.print("Enter new Major: ");
            studentToUpdate.setMajor(scanner.next());
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void deleteStudentById() {
        System.out.print("Enter ID to delete: ");
        String deleteId = scanner.nextLine();
        Student studentToDelete = findStudentById(deleteId);
        if (studentToDelete != null) {
            studentList.remove(studentToDelete);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : studentList) {
                student.displayInfo();
                System.out.println("-------------------------");
            }
        }
    }

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
        System.out.println("Top Student:");
        topStudent.displayInfo();
    }

    public void findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.isScholarship()) {
                scholarshipStudents.add(student);
            }
        }

        if (scholarshipStudents.isEmpty()) {
            System.out.println("No scholarship students found.");
        } else {
            System.out.println("Scholarship Students:");
            for (Student student : scholarshipStudents) {
                student.displayInfo();
                System.out.println("-------------------------");
            }
        }
    }

    public void calculateTuitionOfAllStudents() {
        double totalTuition = 0;
        for (Student student : studentList) {
            totalTuition += student.calculateTuition();
        }
        System.out.println("Total tuition of all students: " + totalTuition);
    }
}
