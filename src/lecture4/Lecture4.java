package lecture4;
import java.util.Scanner;
public class Lecture4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap x: ");
        int x = scanner.nextInt();
        if(x>0){
            System.out.println("So duong!");
        }else if (x<0){
            System.out.println("So am!");
        } else{
            System.out.println("Zero!");
        }
    }
}
