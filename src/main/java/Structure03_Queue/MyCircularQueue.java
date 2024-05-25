package Structure03_Queue;

public class MyCircularQueue<T> implements IQueue<T> {

    private T[] elements;
    private int front;
    private int rear;
    private int maxSize;

    public MyCircularQueue(int size) {
        this.elements = (T[]) new Object[size + 1];
        this.front = 0;
        this.rear = 0;
        this.maxSize= size + 1;
    }

    @Override
    public void offer(T data) {
        // 큐가 꽉찬 경우 exception
         if(this.isFull()) {
             throw new IllegalStateException();
         }
         // 최대 사이즈가 10인 상태에서
         // 값이 들어가고 나가고를 반복하다 rear의 값이 10이라면
         // 다음 값은 1에 들어가야 하기 때문에 11 % 10 을 하여 1로 맞춰 줌
         this.rear = (this.rear + 1) % this.maxSize;
         this.elements[this.rear] = data;
    }

    @Override
    public T poll() {
        // 큐가 비어 있는 상태에서 요청 시 exception
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        // 값이 제외되어야 하므로 front 위치 이동
        this.front = (this.front + 1) % this.maxSize;
        // 이동 후 해당 위치 값 출력
        return this.elements[this.front];
    }

    @Override
    public T peek() {
        // 값이 없는 상태에서 요청 시 exception
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        // front가 이동할 필요 없이 값만 확인 함
        return this.elements[this.front + 1];
    }

    @Override
    public int size() {
        // front가 3 rear가 5의 위치라면 사이즈는 2
        if (this.front <= this.rear) {
            return this.rear - this.front;
        }
        // 만약 front가 5 rear가 3의 위치이고 최대사이즈가 10이라면
        // 10 - 5 + 3 = 8이됨
        // 1-O 2-O 3-O(rear) 4-X 5(front)-X 6-O 7-O 8-O 9-O 10-O
        // 위의 상태로 값이 있는 것 임
        return this.maxSize - this.front + this.rear;
    }

    @Override
    public void clear() {
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    private boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }
}
