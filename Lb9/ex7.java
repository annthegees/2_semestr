import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ex7 {
    static int josephus(List<Integer> list, int k) {
        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int N = 100000;
        long start, end;

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= N; i++) arrayList.add(i);
        start = System.currentTimeMillis();
        int resAL = josephus(arrayList, 2);
        end = System.currentTimeMillis();
        System.out.println("ArrayList: " + (end - start) + " ms, winner=" + resAL);

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= N; i++) linkedList.add(i);
        start = System.currentTimeMillis();
        int resLL = josephus(linkedList, 2);
        end = System.currentTimeMillis();
        System.out.println("LinkedList: " + (end - start) + " ms, winner=" + resLL);
    }
}
