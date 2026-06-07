
import java.util.Scanner;
public class ex2 {
    static String toBinary(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int num = sc.nextInt();
        System.out.println("Двоичное представление: " + toBinary(num));
    }
}
