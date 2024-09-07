package Lecture6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListExercise {
    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers) {
        Scanner sc = new Scanner(System.in);
        System.out.print("So luong phan tu cua mang: ");
        int size = sc.nextInt();
        for(int i=0; i<size; i++){
            System.out.print("numbers [" + i + "]=" + " ");
            int value = sc.nextInt();
            numbers.add(value);
        }
        return numbers;
    }

    // Method xuat du lieu ra man hinh
    public static void DisplayData(ArrayList<Integer> numbers) {
        System.out.println("numbers[]=" + Arrays.toString(numbers.toArray()));
    }

    // Method xóa phần tử lẻ ra khỏi mảng
    public static void removeOddNumbers(ArrayList<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 2 != 0) {
                iterator.remove(); // Xóa phần tử lẻ
            }
        }
    }

    // Method tìm giá trị lớn thứ hai
    public static int findMax2(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("Mang phai co it nhat 2 phan tu!");
        }
        // Loại bỏ các giá trị trùng lặp
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        // Chuyển đổi HashSet thành ArrayList để tìm giá trị lớn thứ hai
        ArrayList<Integer> distinctNumbers = new ArrayList<>(uniqueNumbers);

        // Tìm giá trị lớn nhất và giá trị lớn thứ hai
        Integer max1 = null;
        Integer max2 = null;
        for (int number : distinctNumbers) {
            if (max1 == null || number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number < max1 && (max2 == null || number > max2)) {
                max2 = number;
            }
        }
        return max2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String check;
        do {
            System.out.println("Menu: Nhap Data (phim 1), xuat Data (phim 2)");
            int choice = Integer.parseInt(sc.nextLine()); // Tránh lỗi nhập
            switch (choice) {
                case 1 -> numbers = EnterData(numbers);
                case 2 -> DisplayData(numbers);
                default -> System.out.println("Lua chon khong hop le!");
            }
            // Tương tự cho các case khác
            System.out.println("Nhap yes de tiep tuc chuong trinh: ");
            check = sc.nextLine();
        } while (check.equals("yes"));

        try {
            int secondMax = findMax2(numbers);
            System.out.println("Gia tri lon thu hai la: " + secondMax);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Xóa phần tử lẻ ra khỏi mảng
        removeOddNumbers(numbers);
        // In danh sách sau khi xóa
        System.out.println("Mang sau khi xoa so le la: ");
        System.out.println(numbers);
    }
}
