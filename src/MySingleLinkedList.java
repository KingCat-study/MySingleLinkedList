import java.util.NoSuchElementException;

public class MySingleLinkedList<E> implements MyList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MySingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> result = head;

        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result;
    }

    public void addFirst(E value) {

        Node<E> newNode = new Node<>(value);
        newNode.next = head; // 새 노드의 다음 노드로 head 노드를 연결
        head = newNode; // head 가 가리키는 노드를 새 노드로 변경
        size++;

        /**
         * head.next 노드가 없는 경우는 데이터가 새로 추가한 노드밖에 없는 경우이므로
         * 새로 추가한 노드가 처음이자 마지막 노드이므로 tail = head
         */
        if(head.next == null) {
            tail = head;
        }
    }


    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0 || size == 0) {
            addFirst(value);
            return;
        }

        if(index == size) {
            addLast(value);
            return;
        }

        Node<E> prevNode = search(index - 1);

        Node<E> nextNode = prevNode.next;

        Node<E> newNode = new Node<>(value);

        prevNode.next = newNode;
        newNode.next = nextNode;
        size++;

    }

    @Override
    public E remove(int index) {

        if(size == 0) {
            throw new NoSuchElementException();
        }

        if(index == 0) {
            return removeFirst();
        }
        
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node<E> prevNode = search(index - 1);
        Node<E> removeNode = prevNode.next;
        Node<E> removeNextNode = removeNode.next;

        E returnElement = removeNode.data;

        prevNode.next = removeNextNode;

        //삭제했던 노드가 마지막 노드라면 tail 을 prevNode 로 대체
        if (prevNode.next == null) {
            tail = prevNode;
        }

        removeNode = null;
        size--;

        return returnElement;
    }

    @Override
    public boolean remove(Object value) {

        if(size == 0) {
            throw new NoSuchElementException();
        }

        if(head.data.equals(value)) {
            removeFirst();
            return true;
        }

        boolean hasValue = false;
        Node<E> prevNode = new Node<>();
        Node<E> removeNode = head;

        for(; removeNode != null; removeNode = removeNode.next) {
            if(value.equals(removeNode.data)) {
                hasValue = true;
                break;
            }
            prevNode = removeNode;
        }

        if(removeNode == null) {
            return false;
        }

        prevNode.next = removeNode.next;

        if(prevNode.next == null) {
            tail = prevNode;
        }

        removeNode = null;
        size--;

        return true;
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {

        Node<E> replaceNode = search(index);
        replaceNode.data = value;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(E value) {
        int resultIndex = 0;

        Node<E> findNode = head;
        for(; findNode != null; findNode = findNode.next) {
            if(value.equals(findNode.data)){
                return resultIndex;
            }
            resultIndex++;
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Node<E> x = head;
        for (; x != null;) {
            Node<E> nextNode = x.next;
            x = null;
            x = nextNode;
        }

        head = tail = null;
        size = 0;
    }


    public void addLast(E value) {

        if(size == 0) {
            addFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public E removeFirst() {

        Node<E> headNode = head;

        if(headNode == null) {
            throw new NoSuchElementException();
        }

        E returnElement = headNode.data;

        Node<E> headNextNode = head.next;

        head = headNextNode;
        size--;

        if(size == 0) {
            tail = null;
        }

        return returnElement;
    }
}
