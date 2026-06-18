import java.util.Scanner;
public class ex1910 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int maxSum = 0;
        int bestMiddleIndex = 2;
        for (int i = 0; i <= n - 3; i++) {
            int sum = a[i] + a[i + 1] + a[i + 2];
            if (i == 0 || sum > maxSum) {
                maxSum = sum;
                bestMiddleIndex = i + 2;
            }
        }
        System.out.println(maxSum + " " + bestMiddleIndex);
    }
}