package lecture4;
import java.util.Scanner;
public class Ex2 {
    public static int gocPhanTu(double x, double y) 
    {
        if(x>0 && y>0){
            return 1;
        } else if(x<0 && y>0){
            return 2;
        } else if(x<0 && y<0){
            return 3;
        } else if(x>0 && y<0){
            return 4;
        } else{
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap x=");
        double x = scanner.nextDouble();
        System.out.println("Nhap y=");
        double y= scanner.nextDouble();
        System.out.println("Goc phan tu thu " +  gocPhanTu(x,y));
    }
}
