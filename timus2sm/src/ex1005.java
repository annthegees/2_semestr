import java.util.Scanner;

public class ex1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] weights = new int[n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            totalSum += weights[i];
        }

        int minDifference = Integer.MAX_VALUE;


        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += weights[i];
                }
            }
            int diff = Math.abs(totalSum - 2 * sum);
            if (diff < minDifference) {
                minDifference = diff;
            }
        }

        System.out.println(minDifference);
    }

}
