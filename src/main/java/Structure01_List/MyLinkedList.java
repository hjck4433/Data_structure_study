package Structure01_List;

public class MyLinkedList<T> implements IList<T> {

    private int size;
    private Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(null); // dummy head node
    }
    @Override
    public void add(T t) {
        Node curr = this.head;
        // 데이터가 없을 때 까지 (다음이 null) 노드를 타고 들어감
        while(curr.next != null) {
            curr = curr.next;
        }
        // t 데이터를 값으로 가지는 노드 생성
        Node node = new Node(t);
        // 새롭게 생성 된 노드를 가리킴
        curr.next = node;
        // 사이즈 + 1
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        // 없는 인덱스인 경우
        // 인덱스 값과 사이즈가 같은 경우 가장 마지막에 값 추가 됨
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // 이전 노드
        Node prev = this.head;
        // 현재 노드
        Node curr = prev.next;
        int i = 0;
        // 삽입할 인덱스까지 찾아감
        while (i++ < index) {
            prev = prev.next;
            curr = curr.next;
        }
        // 새로운 노드 생성 (데이터/ 기존의 해당 인덱스 노드를 다음 노드로 함)
        Node node = new Node(t, curr);
        // 그 전 노드의 다음 노드는 추가 된 노드
        prev.next = node;
        // 사이즈 + 1
        this.size++;
    }

    @Override
    public void clear() {
        // 초기화
        this.size = 0;
        this.head.next = null;
    }

    @Override
    public boolean delete(T t) {
        Node prev = this.head;
        Node curr = prev.next;
        while(curr != null) {
            // t를 값으로 하는 노드를 찾으면
            if(curr.data.equals(t)) {
                // 이전 노드의 다음 노드를 현재 노드의 다음으로 이어주고
                prev.next = curr.next;
                // 해당 값을 가지는 노드의 다음은 null
                curr.next = null;
                // 사이즈 - 1;
                this.size--;
                return true;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        // 없는 인덱스인 경우
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = this.head;
        Node curr = prev.next;
        int i = 0;
        // 삭제할 인덱스까지 찾아감
        while(i++ < index){
            prev = prev.next;
            curr = curr.next;
        }
        // 이전 노드의 다음 노드는 해당 인덱스의 다음 노드
        prev.next = curr.next;
        // 해당 인덱스의 다음은 null
        curr.next = null;
        // 사이즈 -1
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        // 없는 인덱스인 경우
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // 시작 노드
        Node curr = this.head.next;
        int i = 0;
        while(i++ < index) {
            // 인덱스에 해당하는 노드
            curr = curr.next;
        }
        // 값 반환
        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        // 시작 노드
        Node curr = this.head.next;
        int index = 0;
        while (curr != null) {
            // t와 일치하는 값을 가진 노드라면
            if (t.equals(curr.data)) {
                // 인덱스 반환
                return index;
            }
            // 일치 하지 않으면 다음 노드로 이동
            curr = curr.next;
            // 인덱스 + 1
            index++;
        }
        // 일치하는 노드가 없을 시 -1
        return -1;
    }

    @Override
    public boolean isEmpty() {
        // 헤드의 다음 값이 null 이라면 empty
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        // 시작 노드
        Node curr = this.head.next;
        while(curr != null) {
            // 현재 노드의 값이 t라면
            if (t.equals(curr.data)){
                // true 반환
                return true;
            }
            // 다음 노드로 이동
            curr = curr.next;
        }
        // 해당하는 값이 없다면 false 반환
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
