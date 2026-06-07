public class ex502 {
    public static void main(String[] args) {
        Node head = null;
        Node tail = null;
        for (int i = 1; i <= 5; i++) {
            Node newNode = new Node(i, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Вывод
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}
