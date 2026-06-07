import java.util.HashMap;
import java.util.Map;

public class ex6 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "str" + i);
        }
        // ключ > 5
        System.out.println("Ключи > 5:");
        map.entrySet().stream().filter(e -> e.getKey() > 5).forEach(System.out::println);

        // ключ == 0
        if (map.containsKey(0)) {
            System.out.println("Строки через запятую: " + String.join(",", map.values()));
        }

        // произведение ключей где длина строки > 5
        long product = map.entrySet().stream()
                .filter(e -> e.getValue().length() > 5)
                .mapToInt(Map.Entry::getKey)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Произведение ключей (длина строки > 5): " + product);
    }
}
