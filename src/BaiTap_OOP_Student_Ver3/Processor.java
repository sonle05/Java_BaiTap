package BaiTap_OOP_Student_Ver3;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        PersonList personList = new PersonList();  // Tạo đối tượng PersonList
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Hiển thị menu
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update a person by ID");
            System.out.println("4. Delete a person by ID");
            System.out.println("5. Find a person by ID");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();  // Nhập tùy chọn từ người dùng
            scanner.nextLine();  // Đọc bỏ dòng trống

            // Chỉ gọi các phương thức từ PersonList
            switch (option) {
                case 1:
                    personList.addStudent();  // Thêm sinh viên
                    break;
                case 2:
                    personList.addTeacher();  // Thêm giáo viên
                    break;
                case 3:
                    personList.updatePerson();  // Cập nhật thông tin
                    break;
                case 4:
                    personList.deletePersonById();  // Xóa theo ID
                    break;
                case 5:
                    personList.findPersonById();  // Tìm theo ID
                    break;
                case 6:
                    personList.displayEveryone();  // Hiển thị tất cả
                    break;
                case 7:
                    personList.findTopStudent();  // Tìm sinh viên GPA cao nhất
                    break;
                case 8:
                    personList.findTeacherByDepartment();  // Tìm giáo viên theo khoa
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (option != 9);

        scanner.close();  // Đóng Scanner
    }
}
