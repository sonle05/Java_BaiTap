package Lecture3;


import java.util.Arrays;
import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu: ");
        int n = sc.nextInt();
        
        //Khai bao mang
        int[] array = new int[n];
        System.out.print("Nhap cac phan tu cua mang: ");
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        
        //Khai bao MAX , MIN
        int max = array[0];
        int min = array[0];
        
        //Tim gia tri MAX , MIN
        for(int i = 1; i < n; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        
        //Tinh tong cac phan tu trong mang
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += array[i];
        }
        
        //Tinh gia tri trung binh cua cac phan tu trong mang
        int tb = sum/n;
        
        //Sap xep mang theo thu tu tang dan
        for(int i=0; i < n-1; i++){
            for(int j=0; j < n-i-1; j++){
                if(array[j] > array[j+1]){
                    //Hoan doi gia tri
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        
        //in ra man hinh
        System.out.println("Gia tri lon nhat = " + max);
        System.out.println("Gia tri nho nhat = " + min);
        System.out.println("Tong cua cac phan tu trong mang = " + sum);
        System.out.println("Gia tri TB cua cac phan tu trong mang = " + tb);
        System.out.println("Mang sau khi da sap xep tang dan la: " + Arrays.toString(array));
        //close the scanner
        sc.close();
    }
}
