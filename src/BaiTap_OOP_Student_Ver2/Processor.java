package BaiTap_OOP_Student_Ver2;

import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Show scholarship students");
            System.out.println("7. Show total tuition of all students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1:
                    studentList.addStudent();
                    break;

                case 2:
                    studentList.updateStudentById();
                    break;

                case 3:
                    studentList.deleteStudentById();
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    studentList.findTopStudent();
                    break;

                case 6:
                    studentList.findScholarshipStudents();
                    break;

                case 7:
                    studentList.calculateTuitionOfAllStudents();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (option != 8);

        scanner.close(); // Đóng scanner
    }
}
