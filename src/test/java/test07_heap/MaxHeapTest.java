package test07_heap;

import Structure07_Heap.IHeap;
import Structure07_Heap.MaxHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxHeapTest {
    @Test
    public void basic() {
        // 0~5까지 정렬되지 않은 순서로 값 추가 (2 제외)
        IHeap<Integer> given = new MaxHeap<>(300);
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        // 값 포함 여부 확인
        assertTrue(given.contains(0));
        assertTrue(given.contains(1));
        // 2는 추가하지 않았으므로 false 확인
        assertFalse(given.contains(2));
        assertTrue(given.contains(3));
        assertTrue(given.contains(4));
        assertTrue(given.contains(5));

        // 총 사이즈 5 확인
        assertEquals(5, given.size());
        // pop()으로 가장 첫번째 값이 5->0 크기 순으로 나오는 지 확인
        assertEquals(5, given.pop());
        assertEquals(4, given.pop());
        assertEquals(3, given.pop());
        assertEquals(1, given.pop());
        assertEquals(0, given.pop());
        // 모든 값이 빠져나왔으므로 사이즈 0 확인
        assertEquals(0, given.size());
    }
}
