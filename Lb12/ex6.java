import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ex6 {
    public static void main(String[] args) throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        int chunkSize = (int) Math.ceil(array.length / (double) cores);
        Future<Integer>[] futures = new Future[cores];

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            futures[i] = executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) sum += array[j];
                return sum;
            });
        }

        int totalSum = 0;
        for (Future<Integer> f : futures) {
            totalSum += f.get();
        }
        executor.shutdown();
        System.out.println("Сумма: " + totalSum);
    }
}
