package Lecture1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */




public class Homework
{  
    public static void main(String[] args)
    {
        int number1=10;
        int number2=2;
        
        //Phep cong
        int sum=number1 + number2;
        System.out.println("Phep cong:" + number1 + "+" + number2 + "=" + sum);
        
        //Phep tru
        int dif=number1 - number2;
        System.out.println("Phep tru: " + number1 + "-" + number2 + "=" + dif);
        
        //Phep nhan
        int mul=number1 * number2;
        System.out.println("Phep nhan:" + number1 + "*" + number2 + "=" + mul);
                
        //Phep chia
        int div=number1 / number2;
        System.out.println("Phep chia:" +number1 + "/" + number2 + "=" + div);
        
        //Phep chia lay du
        int divGetRemainder=number1 % number2;
        System.out.println("Phep chia lay du:" + number1 + "%" + number2 + "=" + divGetRemainder);
    }
}

