package test03_queue;

import Structure03_Queue.IQueue;
import Structure03_Queue.MyLinkedQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedQueueTest {

    @Test
    public void basic() {
        IQueue<Integer> given = new MyLinkedQueue<>();
        // 초기 사이즈 0 확인
        assertEquals(given.size(), 0);
        // 초기 데이터 없음 확인
        assertTrue(given.isEmpty());

        // 0~9까지 값 추가
        for (int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i+1);
        }

        for (int i = 0; i < 10; i++){
            // 현재 사이즈
            int currSize = given.size();
            // 가장 오래된 값 (값 삭제 되지 않음)
            int peek = given.peek();
            // 사이즈 체크
            assertEquals(given.size(), currSize);
            // 가장 오래된 값 확인
            assertEquals(peek, i);
            // 가장 오래된 값 꺼냄 (삭제 됨)
            int poll = given.poll();
            // 값 일치 확인
            assertEquals(peek, poll);
            // 사이즈 감소 확인
            assertEquals(given.size(), currSize -1);
        }
    }

    @Test
    public void offer_remove_offer() {
        IQueue<Integer> given = new MyLinkedQueue<>();
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());

        // 0~9까지 값 입력
        for(int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i + 1);
        }
        // 0~9까지 값 다시 꺼냄
        for (int i = 0; i < 10; i++) {
            given.poll();
        }
        // 10~19까지 갑 입력
        for (int i = 10; i < 20; i++){
            given.offer(i);
        }
        // 10 ~ 19 가장 오래된 값 확인 후 꺼냄
        for (int i = 10; i < 20; i++) {
            int peek = given.peek();
            assertEquals(peek, i);
            assertEquals(peek, given.poll());
        }

        // 모든 데이터를 다시 꺼냈기 때문에 사이즈 0 확인
        assertEquals(given.size(), 0);
        // 비어있는 것 확인
        assertTrue(given.isEmpty());
    }

    @Test
    public void clear() {
        IQueue<Integer> given = new MyLinkedQueue<>();
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());

        // 0~9까지 값 입력
        for(int i = 0; i < 10; i++){
            given.offer(i);
            assertEquals(given.size(), i+1);
        }

        // 초기화
        given.clear();
        // 사이즈 0 확인
        assertEquals(given.size(), 0);
        // 비어있는 것 확인
        assertTrue(given.isEmpty());
        // 비어 있으므로 값과 관련된 요청 시 exception 발생 확인
        assertThrows(IllegalStateException.class, given::poll);
        assertThrows(IllegalStateException.class, given::peek);
    }
}
