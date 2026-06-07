import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ex5 {
    public static void main(String[] args) throws Exception {
        int[] array = {3, 5, 1, 8, 2, 9, 4, 7, 6, 10};
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        int chunkSize = (int) Math.ceil(array.length / (double) cores);
        Future<Integer>[] futures = new Future[cores];

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            futures[i] = executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > max) max = array[j];
                }
                return max;
            });
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> f : futures) {
            globalMax = Math.max(globalMax, f.get());
        }
        executor.shutdown();
        System.out.println("Максимум: " + globalMax);
    }
}
