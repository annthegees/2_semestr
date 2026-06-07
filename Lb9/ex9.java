import java.util.*;

public class ex9 {

    public static void main(String[] args) {
        int N = 2_000_000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> sortedSet = new TreeSet<>();

        // Заполнение
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
            linkedList.add(i);
            sortedSet.add(i);
        }

        // 1. Добавление в начало
        long t = System.nanoTime();
        arrayList.add(0, -1);
        System.out.println("ArrayList addFirst: " + (System.nanoTime() - t) + " ns");
        t = System.nanoTime();
        linkedList.add(0, -1);
        System.out.println("LinkedList addFirst: " + (System.nanoTime() - t) + " ns");

        // 2. Добавление в конец
        t = System.nanoTime();
        arrayList.add(N, -1);
        System.out.println("ArrayList addLast: " + (System.nanoTime() - t) + " ns");
        t = System.nanoTime();
        linkedList.add(N, -1);
        System.out.println("LinkedList addLast: " + (System.nanoTime() - t) + " ns");

        // 3. Добавление в середину
        t = System.nanoTime();
        arrayList.add(N/2, -1);
        System.out.println("ArrayList addMiddle: " + (System.nanoTime() - t) + " ns");
        t = System.nanoTime();
        linkedList.add(N/2, -1);
        System.out.println("LinkedList addMiddle: " + (System.nanoTime() - t) + " ns");

        // 4-6. Удаление аналогично
        // 7. Получение по индексу (для SortedSet не определено)
        t = System.nanoTime();
        int val = arrayList.get(N/2);
        System.out.println("ArrayList get: " + (System.nanoTime() - t) + " ns");
        t = System.nanoTime();
        val = linkedList.get(N/2);
        System.out.println("LinkedList get: " + (System.nanoTime() - t) + " ns");
    }
}
