public class ex5 {
    public static void main(String[] args) {
        Node head = null;
        for (int i = 5; i >= 1; i--) {
            head = new Node(i, head);  // новый узел становится головой
        }

        // Вывод
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}
