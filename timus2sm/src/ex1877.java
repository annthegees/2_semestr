import java.util.Scanner;
public class ex1877 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code1 = scanner.nextLine();
        String code2 = scanner.nextLine();
        if (code1.compareTo(code2) > 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}