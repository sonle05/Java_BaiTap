package BaiTap_OOP_Student_Ver1;
import java.util.Date;
import java.text.SimpleDateFormat;

abstract class Person {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Person(String id, String fullName, Date dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

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
    
    public String getFormatDateOfBirth() {
        return sdf.format(dateOfBirth);
    }

    public abstract void displayInfo();
}


