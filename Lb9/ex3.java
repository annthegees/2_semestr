import java.util.Scanner;

public class ex3 {
    static void inputArray(int[] arr, int index, Scanner sc) {
        if (index == arr.length) return;
        System.out.print("arr[" + index + "] = ");
        arr[index] = sc.nextInt();
        inputArray(arr, index + 1, sc);
    }

    static void outputArray(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.print(arr[index] + " ");
        outputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Размер массива: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        inputArray(arr, 0, sc);
        System.out.print("Массив: ");
        outputArray(arr, 0);
    }
}
