import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex1 {
    // 1. Четные числа из массива
    public static int[] filterEven(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    // 2. Общие элементы двух массивов
    public static int[] getIntersection(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .filter(n -> Arrays.stream(arr2).anyMatch(m -> m == n))
                .distinct()
                .toArray();
    }

    // 3. Строки, начинающиеся с большой буквы
    public static List<String> startsWithUpperCase(List<String> strings) {
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    // 4. Список квадратов чисел
    public static List<Integer> squares(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // 5/ Числа, большие заданного значения
    public static List<Integer> greaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }

    // 6. Числа, делящиеся на заданное число без остатка
    public static List<Integer> getNumbersDivisibleBy(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }

    // 7. Строки длиной больше заданного значения
    public static List<String> getStringsLongerThan(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s != null && s.length() > minLength)
                .collect(Collectors.toList());
    }

    // 8. Числа больше заданного значения
    public static List<Integer> getNumbersGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }

    // 9. Строки, содержащие только буквы (без цифр и символов)
    public static List<String> getOnlyLettersStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> s != null && s.matches("^[a-zA-Zа-яА-Я]+$"))
                .collect(Collectors.toList());
    }

    // 10. Числа меньше заданного значения
    public static List<Integer> getNumbersLessThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }
}
