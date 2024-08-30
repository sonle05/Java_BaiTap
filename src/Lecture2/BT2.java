package Lecture2;


import java.util.Scanner;
public class BT2 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Full Name: ");
        String fullname = scanner.nextLine();
        
        System.out.println("Year of old: ");
        int yearOfOld = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Age: ");
        int age = scanner.nextInt();
        
        System.out.println("Sex: ");
        String sex = scanner.next();
        
        System.out.println("GPA: ");
        float GPA = scanner.nextFloat();
        scanner.nextLine();
        
        System.out.println("Country: ");
        String country = scanner.nextLine();
        
        System.out.println("Name: " + fullname + "-" + "Year Of Old: " + yearOfOld + "-" + "Age: " + age + "-" + "Sex: " + sex + "-" + "GPA: " + GPA + "-" + "Country: " + country);
        

    }
}
