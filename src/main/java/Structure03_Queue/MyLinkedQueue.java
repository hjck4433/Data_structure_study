package Structure03_Queue;

public class MyLinkedQueue<T> implements IQueue<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedQueue() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = this.head;
    }

    @Override
    public void offer(T data) {
        // 새 노드
        Node node = new Node(data);
        // 테일 노드 다음에 노드를 추가하고
        this.tail.next = node;
        // 테일을 새 노드로 바꿔 줌
        this.tail = this.tail.next;
        // 사이즈 증가
        this.size++;
    }

    @Override
    public T poll() {
        // 비어 있는 상태에서 요청 시 exception 발생
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        // 가장 앞의 노드
        Node node = this.head.next;
        // 헤드의 다음을 그 다음 노드로 연결
        this.head.next = node.next;
        // 값이 반환될 노드의 연결 해제
        node.next = null;
        // 사이즈 감소
        this.size--;

        // 모든 데이터가 나갔다면 다시 초기화
        if(this.head.next == null) {
            this.tail = this.head;
        }
        // 가장 앞의 노드의 값 반환
        return node.data;
    }

    @Override
    public T peek() {
        // 비어 있는 상태에서 요청 시 exception 발생
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        // 빼내는 것이 아닌 값만 리턴
        return this.head.next.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.tail = head;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {this.data = data;}

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
