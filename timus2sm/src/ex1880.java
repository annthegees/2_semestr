import java.util.*;
public class ex1880 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> p1 = readList(scanner);
        List<Integer> p2 = readList(scanner);
        List<Integer> p3 = readList(scanner);
        Set<Integer> set2 = new HashSet<>(p2);
        Set<Integer> set3 = new HashSet<>(p3);
        int count = 0;
        for (int num : p1) {
            if (set2.contains(num) && set3.contains(num)) {
                count++;
            }
        }
        System.out.println(count);
    }
    private static List<Integer> readList(Scanner scanner) {
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        return list;
    }
}