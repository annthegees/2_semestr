public class ex3 {
    private static int number = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " -> " + number);
                        number++;
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " -> " + number);
                        number++;
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        });

        evenThread.setName("EvenThread");
        oddThread.setName("OddThread");
        evenThread.start();
        oddThread.start();
    }
}
