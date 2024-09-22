package BaiTap_OOP_Student_Ver4;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person implements IPerson {
    private String id;
    private String fullName;
    private Date dateOfBirth;

    public Person(String id, String fullName, Date dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
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

    // Formatting DateOfBirth as dd/MM/yyyy
    public String getFormattedDateOfBirth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dateOfBirth);
    }

    // Abstract methods
    @Override
    public abstract void addPerson();
    @Override
    public abstract void updatePerson(String id);
    @Override
    public abstract void displayInfo();
}
