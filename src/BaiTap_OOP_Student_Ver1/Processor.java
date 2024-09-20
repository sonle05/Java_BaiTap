package BaiTap_OOP_Student_Ver1;
import java.text.ParseException;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by id");
            System.out.println("3. Delete a student by id");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1: // Add a new student
                    studentList.addStudent();
                    break;

                case 2: // Update a student by id
                    studentList.updateStudentById();
                    break;

                case 3: // Delete a student by id
                    studentList.deleteStudentById();
                    break;

                case 4: // Display all students
                    studentList.displayAllStudents();
                    break;

                case 5: // Find the student with the highest GPA
                    studentList.findTopStudent();
                    break;

                case 6: // Exit
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
