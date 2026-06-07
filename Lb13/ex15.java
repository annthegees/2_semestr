import java.util.InputMismatchException;
import java.util.Scanner;

public class ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        try {
            System.out.print("Введите номер столбца (начиная с 0): ");
            int col = scanner.nextInt();

            if (col < 0 || col >= matrix[0].length) {
                throw new ArrayIndexOutOfBoundsException("Нет столбца с номером " + col);
            }

            System.out.println("Столбец " + col + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][col]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: ввод строки вместо числа");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Завершение программы Task2");
        }
    }
}
