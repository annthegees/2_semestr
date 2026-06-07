public class ex4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int num = i;
            new Thread(() -> System.out.println("Поток №" + num)).start();
        }
    }
}
