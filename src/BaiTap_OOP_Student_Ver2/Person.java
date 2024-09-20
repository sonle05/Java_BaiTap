package BaiTap_OOP_Student_Ver2;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person implements IPerson {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor
    public Person(String id, String fullName, Date dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters và Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Abstract method
    public abstract void displayInfo();  // Phương thức sẽ được triển khai trong lớp Student

    // Hiển thị ngày sinh theo định dạng "dd/MM/yyyy"
    public String getFormattedDate() {
        return sdf.format(dateOfBirth);
    }
}


