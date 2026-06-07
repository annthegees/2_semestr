public class ex1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10000) {
                System.out.println(Thread.currentThread().getName() + " - " + new java.util.Date());
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });
        Thread t2 = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10000) {
                System.out.println(Thread.currentThread().getName() + " - " + new java.util.Date());
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
