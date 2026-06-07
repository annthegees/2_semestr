import java.util.InputMismatchException;
import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();

            byte[] arr = new byte[n];
            System.out.println("Введите элементы типа byte (-128..127):");

            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                if (val < Byte.MIN_VALUE || val > Byte.MAX_VALUE) {
                    throw new NumberFormatException("Значение вне диапазона byte");
                }
                arr[i] = (byte) val;
            }

            int sum = 0;
            for (byte b : arr) {
                sum += b;
            }

            if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                throw new ArithmeticException("Сумма выходит за пределы типа byte");
            }

            System.out.println("Сумма элементов: " + sum);
            System.out.println("Как byte: " + (byte) sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: ввод строки вместо числа");
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Ошибка диапазона: " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: отрицательный размер массива");
        } finally {
            System.out.println("Завершение программы Task3");
        }
    }
}
