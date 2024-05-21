package Structure01_List;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T>{
    private static final int DEFAULT_SIZE = 50;

    private int size;
    private T[] elements;

    public MyArrayList() {
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }

    public void newArray () {
        this.elements = Arrays.copyOf(this.elements, this.size * 2);
    }


    @Override
    public void add(T t) {

        if(this.size == this.elements.length) {
            // 공간이 꽉 찬 경우
            // 공간을 2배로 늘려주고 기존 배열을 복사해서 넣어 줌
//            this.elements = Arrays.copyOf(this.elements, this.size * 2);
            newArray();
        }
        // 현재 사이즈에 해당하는 인덱스에 데이터를 저장하고
        // 사이즈를 +1 함으로써 다음 인덱스에 새로운 값이 올 수 있게 됨
        this.elements[this.size++] = t;
    }

    @Override
    public void insert(int index, T t) {
        if(this.size == this.elements.length) {
            // 공간이 꽉 찬 경우
            // 공간을 2배로 늘려주고 기존 배열을 복사해서 넣어 줌
//            this.elements = Arrays.copyOf(this.elements, this.size * 2);
            newArray();
        }
        for (int i = index; i < this.size; i++) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[index] = t;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean delete(T t) {
        for (int i = 0; i < this.size; i++){
            if (this.elements[i].equals(t)) {
                for(int j = i; i <this.size -1; i++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        // 잘못 된 인덱스 값이 들어오는 경우
        if(index < 0 || index > this.size -1) {
            return false;
        }

        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;

        return true;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > this.size -1) {
            // 반환값이 T 이기 때문에 return false가 아닌
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    @Override
    public int indexOf(T t) {
        for(int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(t)){
                return i;
            }
        }
        // 값이 없는 경우 존재하지 않는 인덱스 값인 -1 return
        return -1;
    }

    @Override
    public boolean isEmpty() {
        // size가 0 이면 true 아니면 false
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {

        for(int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
