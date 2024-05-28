package Structure07_Heap;

import java.util.Arrays;
import java.util.Collections;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {

    T[] data;
    int size;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.data = (T[]) new Comparable[maxSize + 1];
        this.size = 0;
    }

    private int parent(int pos) {
        return pos / 2;
    }
    private int leftChild(int pos){
        return pos * 2;
    }
    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos){
        return (pos > (size / 2) && pos <= size);
    }


    @Override
    public void insert(T val) {
        this.data[++this.size] = val;

        int current = this.size;
        // 현재 위치와 부모 노드의 조건 확인
        while (this.data[parent(current)] != null &&
                // 부모노드 보다 자식 노드가 크면
                this.data[current].compareTo(this.data[parent(current)])> 0) {
            // 둘의 값을 바꿈
            Collections.swap(Arrays.asList(this.data), current, parent(current));
            // 현재 위치를 바꿔줌
            current = parent(current);
            // 조건에 맞을 때 까지 반복
        }
    }

    @Override
    public boolean contains(T val) {
        for (int i = 1; i <= this.size; i++) {
            if (val.equals(this.data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T pop() {
        T top = this.data[1];

        this.data[1] = this.data[this.size--];
        heapify(1);

        return top;
    }

    private void heapify(int idx) {
        // 마지막이라면 더 이상 heapify를 할 필요 가 없음
        if (isLeaf(idx)) return;

        // 현재 데이터
        T current = this.data[idx];
        // 왼쪽 자식
        T left = this.data[leftChild(idx)];
        // 오른쪽 자식
        T right = this.data[rightChild(idx)];

        // 왼쪽 자식 또는 오른쪽 자식이 큰 경우
        if (current.compareTo(left) < 0 ||
            current.compareTo(right) < 0) {
            // 왼쪽이 오른쪽 보다 큰 경우
            if (left.compareTo(right) > 0) {
                // 부모노드와 왼쪽 노드의 값을 서로 바꿈
                // leaf노드를 만날때까지 반복시켜줌
                Collections.swap(Arrays.asList(this.data), idx, leftChild(idx));
                heapify(leftChild(idx));
            }else {
                // 오른쪽이 왼족 보다 큰 경우
                // 부모노드와 오른쪽 노드의 값을 서로 바꿈
                // leaf노드를 만날때까지 반복시켜줌
                Collections.swap(Arrays.asList(this.data), idx, rightChild(idx));
                heapify(rightChild(idx));
            }
        }
    }

    @Override
    public T peek() {
        if (this.size < 1) throw new RuntimeException();
        return this.data[1];
    }

    @Override
    public int size() {
        return this.size;
    }
}
