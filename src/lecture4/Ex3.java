package lecture4;
import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n:");
        int n = sc.nextInt();
        switch(n){
            case 5 -> System.out.println("Five \n");
            case 4 -> System.out.println("Four \n");
            case 3 -> System.out.println("Three \n");
            case 2 -> System.out.println("Two \n");
            case 1 -> System.out.println("One \n");
            default -> System.out.println("No \n");
        }
    }
}
