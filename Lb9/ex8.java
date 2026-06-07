public class ex8 {
    // Узел списка
    class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head;

    // ЦИКЛИЧЕСКИЕ МЕТОДЫ

    // 1. Ввод с головы (createHead)
    void createHead(int... values) {
        head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
    }

    // 2. Ввод с хвоста (createTail)
    void createTail(int... values) {
        head = null;
        Node tail = null;
        for (int v : values) {
            Node newNode = new Node(v, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    // 3. Вывод (toString)
    @Override
    public String toString() {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    // 4. Добавление в начало (AddFirst)
    void addFirst(int val) {
        head = new Node(val, head);
    }

    // 5. Добавление в конец (AddLast)
    void addLast(int val) {
        if (head == null) {
            head = new Node(val, null);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val, null);
    }

    // 6. Вставка по номеру (Insert), индекс с 0
    void insert(int index, int val) {
        if (index < 0) return;
        if (index == 0) {
            addFirst(val);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) return;
        current.next = new Node(val, current.next);
    }

    // 7. Удаление с головы (RemoveFirst)
    void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // 8. Удаление последнего (RemoveLast)
    void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // 9. Удаление по номеру (Remove), индекс с 0
    void remove(int index) {
        if (index < 0 || head == null) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) return;
        current.next = current.next.next;
    }

    //РЕКУРСИВНЫЕ МЕТОДЫ

    // 10. Ввод с головы рекурсивно (createHeadRec)
    private Node createHeadRecHelper(int[] values, int index) {
        if (index >= values.length) return null;
        return new Node(values[index], createHeadRecHelper(values, index + 1));
    }

    void createHeadRec(int... values) {
        head = createHeadRecHelper(values, 0);
    }

    // 11. Ввод с хвоста рекурсивно (createTailRec)
    private Node createTailRecHelper(int[] values, int index) {
        if (index >= values.length) return null;
        Node newNode = new Node(values[index], null);
        newNode.next = createTailRecHelper(values, index + 1);
        return newNode;
    }

    void createTailRec(int... values) {
        head = createTailRecHelper(values, 0);
    }

    // 12. Вывод рекурсивно (toStringRec)
    private String toStringRecHelper(Node current) {
        if (current == null) return "";
        String rest = toStringRecHelper(current.next);
        if (rest.isEmpty()) {
            return String.valueOf(current.data);
        } else {
            return current.data + " " + rest;
        }
    }

    String toStringRec() {
        return toStringRecHelper(head);
    }
}

