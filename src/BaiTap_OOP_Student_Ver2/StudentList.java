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
            studentList.add(newStudent);    //Thêm 1 đối tượng student vào danh sách studentList
            System.out.println("Student added successfully!");
            
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd/MM/yyyy.");
        }
    }

    public void updateStudentById() {
        System.out.print("Enter ID to update: ");
        String updateId = scanner.nextLine();
        
        Student studentToUpdate = findStudentById(updateId);
        //Gọi phương thức findStudentById để tìm kiếm sinh viên theo id đã nhập và lưu đối tượng sinh viên vào biến
        if (studentToUpdate != null) {  //Kiểm tra xem sinh viên có tồn tại hay không
            System.out.print("Enter new Full Name: ");
            studentToUpdate.setFullName(scanner.nextLine());
            
            System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
            try {
                Date newDateOfBirth = sdf.parse(scanner.nextLine());    //Đọc ngày sinh mới từ người dùng và chuyển thành chuỗi
                studentToUpdate.setDateOfBirth(newDateOfBirth);
            } catch (ParseException e) {    //Nếu có lỗi trong quá trình phân tích ngày tháng sẽ thực hiện khối lệnh bên trong
                System.out.println("Invalid date format! Please use dd/MM/yyyy.");
                //Thông báo lỗi nếu nhập sai định dạng ngày tháng năm
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
        String deleteId = scanner.nextLine();   //Đọc dữ liệu nhập vào và lưu vào biến deleteId, chứ id của sinh viên cần xoá
        Student studentToDelete = findStudentById(deleteId);    //Gọi phương thức "findStudentById" để tìm kiếm sinh viên theo id đã nhập và lưu đối tượng sinh viên vào biến "studentToDelete"
        if (studentToDelete != null) {  //Kiểm tra xem sinh có tồn tại hay không
            studentList.remove(studentToDelete);    //Nếu sinh viên tồn tại, sử dụng phương thức remove để xoá sinh viên khỏi danh sách studentList
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {   //Bắt đầu vòng lặp qua từng đối tượng Student trong studentList
            if (student.getId().equals(id)) {   //Kiểm tra xem id của student có khớp với id được truyền vào hay không
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : studentList) {   //Bắt đầu vòng lặp qua từng đối tượng Student trong studentList
                student.displayInfo();
                System.out.println("-------------------------");
            }
        }
    }

    public void findTopStudent() {
        if (studentList.isEmpty()) {    // "isEmpty" dùng để kiểm tra xem danh sách có rỗng không
            System.out.println("No students available.");
            return;
        }

        Student topStudent = studentList.get(0);
        //Khởi tạo biến "topStudent" với student đầu tiên trong studentList
        for (Student student : studentList) {   //Bắt đầu vòng lặp qua từng đối tượng Student trong studentList
            if (student.getGpa() > topStudent.getGpa()) {
            //Kiểm tra xem GPA của student hiện tại có lớn hơn GPA của topStudent không
                topStudent = student;
                //Nếu điều kiện trên đúng, gán topStudent cho student hiện tại vì có GPA cao hơn
            }
        }
        System.out.println("Top Student:");
        topStudent.displayInfo();
    }

    public void findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        //Khởi tạo 1 danh sách mới để lưu các sinh viên nhận học bổng
        for (Student student : studentList) {   //Bắt đầu vòng lặp qua từng đối tượng Student trong studentList
            if (student.isScholarship()) {      //Kiểm tra xem sinh viên hiện tại có thuộc diện nhận học bổng hay không 
                scholarshipStudents.add(student);   //Nếu điều kiện đúng, thêm sinh viên hiện tại vào danh sách
            }
        }

        if (scholarshipStudents.isEmpty()) {    //Kiểm tra xem danh sách "scholarshipStudents" có rỗng hay không
            System.out.println("No scholarship students found.");
        } else {    //Nêu có sinh viên nhận học bổng
            System.out.println("Scholarship Students:");    
            for (Student student : scholarshipStudents) {   //Bắt đầu vòng lặp qua đối tượng student trong danh sách "scholarshipStudents"
                student.displayInfo();  //Gọi phương thức displayInfo để hiển thị thông tin của sinh viên
                System.out.println("-------------------------");
            }
        }
    }

    public void calculateTuitionOfAllStudents() {
        double totalTuition = 0;    //Khởi tạo biến totalTuition với giá trị 0 để lưu tổng học phí
        for (Student student : studentList) {   //Bắt đầu vòng lặp qua từng đối tượng Student trong studentList
            totalTuition += student.calculateTuition();     //Gọi phương thức "calculateTuition" để tính học phí, sau đó cộng vào biến totalTuition
        }
        System.out.println("Total tuition of all students: " + totalTuition);
    }
}
