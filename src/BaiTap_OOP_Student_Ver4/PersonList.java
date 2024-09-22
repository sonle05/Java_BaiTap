package BaiTap_OOP_Student_Ver4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PersonList {
    private ArrayList<Person> personList;  // Danh sách chứa cả Student và Teacher
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Scanner scanner = new Scanner(System.in);

    public PersonList() {
        personList = new ArrayList<>();
    }

    // Thêm sinh viên mới
    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Enter Full Name: ");
            String fullName = scanner.nextLine();
            
            System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
            Date dateOfBirth = sdf.parse(scanner.nextLine());
            
            System.out.print("Enter GPA: ");
            float gpa = scanner.nextFloat();
            
            scanner.nextLine();  // Đọc bỏ dòng trống
            
            System.out.print("Enter Major: ");
            String major = scanner.nextLine();

            Student student = new Student(id, fullName, dateOfBirth, gpa, major);
            personList.add(student);
            System.out.println("Student added successfully!");
            
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd/MM/yyyy.");
        }
    }

    // Thêm giáo viên mới
    public void addTeacher() {
        try {
            System.out.print("Enter Teacher ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Enter Full Name: ");
            String fullName = scanner.nextLine();
            
            System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
            Date dateOfBirth = sdf.parse(scanner.nextLine());
            
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();
            
            System.out.print("Enter Teaching Subject: ");
            String teachingSubject = scanner.nextLine();

            Teacher teacher = new Teacher(id, fullName, dateOfBirth, department, teachingSubject);
            personList.add(teacher);
            System.out.println("Teacher added successfully!");
            
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd/MM/yyyy.");
        }
    }

    // Cập nhật thông tin người theo ID
    public void updatePerson() {
        System.out.print("Enter ID to update: ");
        String id = scanner.nextLine();
        Person person = findPersonByIdInternal(id);
        if (person != null) {
            System.out.print("Enter new Full Name: ");
            person.setFullName(scanner.nextLine());
            try {
                System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
                person.setDateOfBirth(sdf.parse(scanner.nextLine()));
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please use dd/MM/yyyy.");
            }

            if (person instanceof Student) {
                System.out.print("Enter new GPA: ");
                ((Student) person).setGpa(scanner.nextFloat());
                
                scanner.nextLine();  // Đọc bỏ dòng trống
                
                System.out.print("Enter new Major: ");
                ((Student) person).setMajor(scanner.nextLine());
                
            } else if (person instanceof Teacher) {
                System.out.print("Enter new Department: ");
                ((Teacher) person).setDepartment(scanner.nextLine());
                
                System.out.print("Enter new Teaching Subject: ");
                ((Teacher) person).setTeachingSubject(scanner.nextLine());
            }

            System.out.println("Person updated successfully!");
        } else {
            System.out.println("Person not found!");
        }
    }

    // Xóa người theo ID
    public void deletePersonById() {
        System.out.print("Enter ID to delete: ");
        String id = scanner.nextLine();
        Person person = findPersonByIdInternal(id);
        if (person != null) {
            personList.remove(person);
            System.out.println("Person deleted successfully!");
        } else {
            System.out.println("Person not found!");
        }
    }

    // Tìm người theo ID
    public void findPersonById() {
        System.out.print("Enter ID to find: ");
        String id = scanner.nextLine();
        Person person = findPersonByIdInternal(id);
        if (person != null) {
            person.displayInfo();
        } else {
            System.out.println("Person not found!");
        }
    }

    // Hiển thị tất cả mọi người
    public void displayEveryone() {
        for (Person person : personList) {
            person.displayInfo();
            System.out.println("--------------------");
        }
    }

    // Tìm sinh viên có GPA cao nhất
    public void findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }

        if (topStudent != null) {
            System.out.println("Top student:");
            topStudent.displayInfo();
        } else {
            System.out.println("No students found!");
        }
    }

    // Tìm giáo viên theo khoa
    public void findTeacherByDepartment() {
        System.out.print("Enter department to find teacher: ");
        String department = scanner.nextLine();
        boolean found = false;
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equalsIgnoreCase(department)) {
                    teacher.displayInfo();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No teachers found in department: " + department);
        }
    }

    // Tìm người theo ID nội bộ (không hiển thị)
    private Person findPersonByIdInternal(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
}

