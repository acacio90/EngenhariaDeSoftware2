package psp2;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insert(DataPair data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    public class Node {
        private DataPair data;
        private Node next;

        public Node(DataPair data) {
            this.data = data;
            this.next = null;
        }

        public DataPair getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
