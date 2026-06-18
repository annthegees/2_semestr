import java.util.Scanner;
public class ex2066 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        min = Math.min(min, a + b + c);
        min = Math.min(min, a + b - c);
        min = Math.min(min, a + b * c);
        min = Math.min(min, a - b + c);
        min = Math.min(min, a - b - c);
        min = Math.min(min, a - b * c);
        min = Math.min(min, a * b + c);
        min = Math.min(min, a * b - c);
        min = Math.min(min, a * b * c);
        System.out.println(min);
    }
}