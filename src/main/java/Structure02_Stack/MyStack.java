package Structure02_Stack;

public class MyStack<T> implements IStack<T> {

    private int size;
    private Node head;

    public MyStack() {
        this.size = size();
        this.head = new Node(null);
    }

    @Override
    public void push(T data) {
        // 헤드 아래에 값을 쌓는 구조
        // 나중에 들어온 노드가 직전 노드 위에 쌓이고
        // 맨 처음 들어온 노드 다음은 null이 됨
        Node node = new Node(data, this.head.next);
        this.head.next = node;
        this.size++;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) return null;
        // 헤드 바로 다음이 가장 위 노드
        Node curr = this.head.next;
        // 헤드와 해당 노드 다음 노드 연결
        this.head.next = curr.next;
        // 해당 노드 분리
        curr.next = null;
        // 사이즈 -1
        this.size--;
        // 해당 노드 값 반환
        return curr.data;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) return null;
        // 가장 상위 노드 값을 출력만 시키는 것으로 분리 필요 x
        return this.head.next.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean isEmpty() {
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
