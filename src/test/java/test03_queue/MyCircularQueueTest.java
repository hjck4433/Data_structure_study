package test03_queue;

import Structure03_Queue.IQueue;
import Structure03_Queue.MyCircularQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyCircularQueueTest {
    @Test
    public void basic() {
        // 최대 허용 사이즈 30의 새 큐 생성
        IQueue<Integer> given = new MyCircularQueue<>(30);
        // 사이즈 0 확인
        assertEquals(given.size(), 0);
        // 비어있는 상태 확인
        assertTrue(given.isEmpty());
        
        // 0~9 까지 갑 추가
        for (int i = 0; i < 10; i++){
            given.offer(i);
            assertEquals(given.size(), i+1);
        }
        
        for (int i = 0; i < 10; i++){
            // 현재 사이즈
            int currSize = given.size();
            // 가장 오래된 값
            int peek = given.peek();
            // 사이즈 확인
            assertEquals(given.size(), currSize);
            // 가장 오래된 값 확인
            assertEquals(peek, i);
            // 가장 오래된 값 빼냄
            int poll = given.poll();
            // 값 확인
            assertEquals(peek, poll);
            // 사이즈 감소 확인
            assertEquals(given.size(), currSize - 1);
        }
        // 모든 데이터를 빼내었으므로 사이즈 0 확인
        assertEquals(given.size(), 0);
        // 비어있는 것 확인
        assertTrue(given.isEmpty());
    }
    
    @Test
    public void offer_too_much() {
        // 최대 사이즈 30 큐 생성
        IQueue<Integer> given = new MyCircularQueue<>(30);
        // 0~29까지 총 30개의 데이터 추가
        for (int i = 0; i < 30; i++) {
            given.offer(i);
            assertEquals(i + 1, given.size());
        }
        // 값 추가 시 exception 발생 확인
        assertThrows(IllegalStateException.class, () -> given.offer(100));
    }
    
    @Test
    public void offer_remove_offer() {
        IQueue<Integer> given = new MyCircularQueue<>(30);
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());
        
        // 0~9까지 데이터 추가
        for (int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i + 1);
        }
        // 모든 데이터 들어온 순서대로 다시 빼냄
        for(int i = 0;  i < 10; i++){
            int ret = given.poll();
            assertEquals(i, ret);
        }
        // 10~19까지 데이터 추가
        for (int i = 10; i < 20; i++) {
            given.offer(i);
        }
        // 모든 데이터 들어온 순서대로 다시 빼냄
        // 10~19의 순서대로 빠지는 것 확인
        for (int i = 10; i < 20; i++) {
            int peek = given.peek();
            assertEquals(peek, i);
            assertEquals(peek, given.poll());
        }
        // 사이즈 0, 큐 비어있는 것 확인
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());
    }
    
    @Test
    public void clear() {
        IQueue<Integer> given = new MyCircularQueue<>(30);
        assertEquals(given.size(),0);
        assertTrue(given.isEmpty());
        // 0~9까지 갑 추가
        for(int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i +1);
        }
        // 초기화
        given.clear();
        // 사이즈, 큐 비어있는 것 확인
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());
        // 비어 있기 때문에 데이터 관련 요청 exception 확인
        assertThrows(IllegalStateException.class, given::poll);
        assertThrows(IllegalStateException.class, given::peek);
    }
}
