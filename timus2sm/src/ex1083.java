import java.util.Scanner;

public class ex1083 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String exclamations = scanner.next(); // строка из !!!

        int k = exclamations.length(); // количество восклицательных знаков

        long result = 1;
        for (int i = n; i > 0; i -= k) {
            result *= i;
        }

        System.out.println(result);
    }
}
