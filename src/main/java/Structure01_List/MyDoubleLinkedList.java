package Structure01_List;

public class MyDoubleLinkedList<T> implements IList<T> {
    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null); // dummy head node
        this.tail = new Node(null); // dummy tail node
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public void add(T t) {
        // 마지막 노드는 tail
        Node last = this.tail.prev;
        // 새 노드 생성 (데이터, prev, next)
        Node node = new Node(t, last, tail);
        // 마지막이었던 노드 다음에 새 노드 이어주기
        last.next = node;
        // tail의 이전은 새 노드로 변경
        this.tail.prev = node;
        // 사이즈 + 1
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        // 존재하지 않는 인덱스의 경우
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = null;
        Node curr = null;
        int i = 0;

        if(index < this.size / 2) { // head에서 시작
            // 시작 이전 노드
            prev = this.head;
            // 시작 노드
            curr = this.head.next;

            while(i++ < index){
                // 헤드에서 next 방향으로 한칸씩 이동
                prev = prev.next;
                curr = curr.next;
            }

        }else { // tail에서 시작
            // 마지막 노드
            curr = this.tail;
            // 마지막 이전 노드
            prev = this.tail.prev;
            // tail에서 prev 방향으로 한칸씩 이동
            while(i++ < (this.size - index)){
                curr = curr.prev;
                prev = prev.prev;
            }

        }
        // 새노드 (데이터,prev,next)
        // prev <=> node <=> curr 
        Node node = new Node(t, prev, curr);
        curr.prev = node;
        prev.next = node;
        // 사이즈 + 1
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = tail;
        this.head.prev = null;
        this.tail.next = null;
        this.tail.prev = head;
    }

    @Override
    public boolean delete(T t) {
        // 탐색은 앞에서 부터 시작
        // 중복 값이 있을 시 맨 앞 인덱스에 위치한 값 삭제
        Node prev = this.head;
        Node curr = prev.next;
        while(curr != null){
            // 노드의 데이터와 삭제할 데이터가 일치하면
            if (curr.data.equals(t)){
                // prev <=> curr <=> next
                // prev <=> next
                prev.next = curr.next;
                curr.next.prev = prev;
                curr.next = null;
                curr.prev = null;
                // 사이즈 - 1
                this.size--;
                return true;
            }
            // 다음 노드로 이동
            prev = prev.next;
            curr = curr.next;
        }

//        // 시작
//        Node next = this.head;
//        // 끝
//        Node prev = this.tail;
//        Node curr = null;
//
//        int i = 0;
//        // 사이즈만큼 순회
//        while (i++ <= this.size){
//            // 시작 => 다음 노드 => 다음 노드
//            next = next.next;
//            // 끝 => 이전 노드 => 이전 노드
//            prev = prev.prev;
//            if(t.equals(next.data)){
//                curr = next;
//                prev = curr.prev;
//                next = curr.next;
//
//            }else if (t.equals(prev.data)){
//                curr = prev;
//                prev = curr.prev;
//                next = curr.next;
//            }
//            if(curr != null) {
//                prev.next = next;
//                next.prev = prev;
//                curr.next = null;
//                curr.prev = null;
//                this.size--;
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        // 존재하지 않는 인덱스의 경우
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = null;
        Node curr = null;
        Node next = null;

        int i = 0;
        if (index < this.size / 2) { // head로 부터 시작
            prev = this.head;
            curr = this.head.next;
            // next 방향으로 하나 씩 이동
            while (i++ < index){
                prev = prev.next;
                curr = curr.next;
            }
            // prev <=> curr <=> next
            // prev <=> next
            prev.next = curr.next;
            curr.next.prev = prev;
            curr.next = null;
            curr.prev = null;
        }else {
            // tail로부터 시작
            curr = this.tail.prev;
            next = this.tail;
            // prev 방향으로 하나 씩 이동
            while(i++ < (this.size - index -1)){
                next = next.prev;
                curr = curr.prev;
            }
            // prev <=> curr <=> next
            // prev <=> next
            next.prev = curr.prev;
            curr.prev.next = next;
            curr.next = null;
            curr.prev = null;
        }
        // 사이즈 -1
        this.size--;

        return true;
    }

    @Override
    public T get(int index) {
        // 존재하지 않는 인덱스의 경우
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        Node curr = null;
        if (index < this.size / 2) {
            // index가 head에 가까우면
            // 시작 노드
            curr = this.head.next;
            while(i++ < index) {
                // 해당 인덱스 만큼 이동
                curr = curr.next;
            }
        }else {
            // index가 tail에 가까우면
            // 마지막 노드
            curr = this.tail.prev;
            while(i++ < (this.size - index - 1)){
                // 뒤에서 부터 이동
                curr = curr.prev;
            }
        }
        // 값 반환
        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        // 앞에서 부터 탐색 
        Node curr = this.head.next;
        int index = 0;
        while(curr != null){
            // 찾는 데이터와 노드의 데이터가 일치하면
            if(t.equals(curr.data)){
                // 인덱스 반환
                return index;
            }
            // 다음 노드
            curr = curr.next;
            // 인덱스 증가
            index++;
        }

        // 시작
//        Node next = this.head;
//        // 끝
//        Node prev = this.tail;
//
//        int i = 0;
//
//        while (i++ < (this.size / 2 + 1 )) {
//            next = next.next;
//            prev = prev.prev;
//            // 시작에서 접근해서 먼저 찾은 경우 실제 인덱스는 i - 1
//            if (t.equals(next.data)) {
//                return i -1;
//            }else if (t.equals(prev.data)) {
//                // 끝에서 접근해서 먼저 찾은 경우 사이즈 - i 값이 인덱스 값
//                return this.size - i ;
//            }
//        }
        // 업는 값은 -1반환
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {
        // 시작
        Node next = this.head;
        // 끝
        Node prev = this.tail;

        int i = 0;
        
        // 시작과 끝에서 동시에 탐색
        while (i++ < (this.size / 2 + 1)) {
            next = next.next;
            prev = prev.prev;
            // 둘 중 하나라도 일치하는 값이 나오면 true 반환
            if (t.equals(next.data) || t.equals(prev.data)) {
                return true;
            }
        }
        // 없는 값은 false 반환
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {this.data = data;}

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
