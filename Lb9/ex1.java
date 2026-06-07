public class ex1 {
    // Пример 1: вывод последовательности x = 2*x+1, пока x < 20
    static void example1(int x) {
        if (x >= 20) return;
        System.out.print(x + " ");
        example1(2 * x + 1);
    }

    // Пример 2: вывод в обратном порядке
    static void example2(int x) {
        if (x >= 20) return;
        example2(2 * x + 1);
        System.out.print(x + " ");
    }

    // Пример 3: до и после рекурсивного вызова
    static void example3(int x) {
        if (x >= 20) return;
        System.out.print("до:" + x + " ");
        example3(2 * x + 1);
        System.out.print("после:" + x + " ");
    }

    // Пример 4: факториал
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Пример 5: Фибоначчи с выводом дерева вызовов
    static int fibWithTrace(int n, String indent) {
        System.out.println(indent + "fib(" + n + ")");
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res = fibWithTrace(n - 1, indent + "  ") + fibWithTrace(n - 2, indent + "  ");
        System.out.println(indent + "возврат " + res + " для fib(" + n + ")");
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=== Пример 1 ===");
        example1(1);
        System.out.println("\n=== Пример 2 ===");
        example2(1);
        System.out.println("\n=== Пример 3 ===");
        example3(1);
        System.out.println("\n=== Пример 4: факториал 5 = " + factorial(5));
        System.out.println("\n=== Пример 5: дерево вызовов fib(4) ===");
        fibWithTrace(4, "");
    }
}
