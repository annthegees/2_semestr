import java.util.Scanner;

public class ex2100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        int k = 0;

        for (int i = 0; i < n; i++) {
            String response = scanner.nextLine().trim();
            if (response.endsWith("+one")) {
                k++;
            }
        }
        int total = n + 2 + k;

        if (total == 13) {
            total++;
        }

        int cost = total * 100;

        System.out.println(cost);

        scanner.close();
    }
}