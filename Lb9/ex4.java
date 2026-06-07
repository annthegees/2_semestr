class Node {
    int value;
    Node next;
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class ex4 {
    public static void main(String[] args) {
        // Создание трёх независимых узлов
        Node third = new Node(3, null);
        Node second = new Node(2, third);
        Node head = new Node(1, second);

        // Вывод списка
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

}
