public class Node<E> {

    E data;
    Node<E> next;

    Node() {
        this.data = null;
        this.next = null;
    }

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}
