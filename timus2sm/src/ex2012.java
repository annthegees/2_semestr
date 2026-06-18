import java.util.Scanner;
public class ex2012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt(); // задач за первый час
        int remainingTasks = 12 - f;
        int timeNeeded = 60 + remainingTasks * 45;
        if (timeNeeded <= 300) { // 5 часов = 300 минут
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}