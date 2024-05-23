package test01_list;

import Structure01_List.IList;
import Structure01_List.MyDoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MyDoubleLinkedListTest {
    @Test
    public void add() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0~49까지 값 추가
        for(int i = 0; i < 50; i++) {
            given.add(i);
            // 사이즈 증가 확인
            assertEquals(i + 1, given.size());
            // 인덱스와 일치하는 값 확인
            assertEquals(i, given.get(i));
        }
        // 10번 인덱스에 값 999 삽입
        given.insert(10, 999);
        // 사이즈 증가 확인
        assertEquals(51, given.size());
        // 10번 인덱스의 값 999 화인
        assertEquals(999, given.get(10));
        // 47번 인덱스에 값 998 삽입
        given.insert(47, 998);
        // 사이즈 증가 확인
        assertEquals(52, given.size());
        // 998데이터의 인덱스 47 확인
        assertEquals(998, given.get(47));
    }

    @Test
    public void get() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0 ~ 49 까지 값 추가
        for(int i = 0; i < 50; i++){
            given.add(i);
        }
        // 0번 인덱스 값 0, 1번 인덱스 1 ... 확인
        for (int i = 0; i < 50; i++) {
            assertEquals(i, given.get(i));
        }
    }
    
    @Test
    public void insert() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 값 9,8,7 추가
        given.add(9);
        given.add(8);
        given.add(7);
        
        // 0번 인덱스 값 1 삽입
        given.insert(0,1);
        // 사이즈 증가 확인
        assertEquals(given.size(), 4);
        // 0번 인덱스 값 1 확인
        assertEquals(1, given.get(0));
        
        // 4번 인덱스 값 10 삽입
        given.insert(4,10);
        // 사이즈 증가 확인
        assertEquals(given.size(), 5);
        // 4번 인덱스 값 10 확인
        assertEquals(10, given.get(4));
    }
    
    @Test
    public void indexOf(){
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0 ~ 49까지 값 추가
        for (int i = 0; i < 50; i++){
            given.add(i);
        }
        // 값 0의 인덱스 0, 1의 인덱스 1 .... 확인
        for (int i = 0; i <50; i++){
            int idx = given.indexOf(i);
            assertEquals(i, idx);
        }
    }

    @Test
    public void insert2() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0번 인덱스에 값 삽입
        given.insert(0, 1);
        // 사이즈 증가 확인
        assertEquals(1, given.size());

        // 1번 인덱스에 값 삽입
        given.insert(1, 2);
        // 사이즈 증가 확인
        assertEquals(2, given.size());

        // 0번 인덱스 값 1 확인
        assertEquals(1, given.get(0));
        // 1번 인덱스 값 2 확인
        assertEquals(2, given.get(1));
    }

    @Test
    public void insert_exception() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 길이가 0인 상태에서 2번 인덱스 삽입 불가
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
           given.insert(2,1);
        });
    }
    
    @Test
    public void clear() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0~ 99까지 값 추가
        for (int i = 0; i < 100; i++){
            given.add(i);
        }
        // 사이즈 100 확인
        assertEquals(100, given.size());
        // 초기화 전 isEmpty false 확인
        assertFalse(given.isEmpty());
        // 초기화
        given.clear();
        // 사이즈 0 확인
        assertEquals(0, given.size());
        // isEmpty true 확인
        assertTrue(given.isEmpty());
    }

    @Test
    public void deleteByIndex() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0 ~ 99 까지 값 추가
        for (int i = 0; i < 100; i++){
            given.add(i);
        }
        Random random = new Random();
        // 0~98까지 랜덤 값
        int givenIndex = random.nextInt(99);
        // 랜덤 값 + 1
        int expected = given.get(givenIndex + 1);
        // 랜덤 인덱스 위치의 노드 삭제
        given.deleteByIndex(givenIndex);

        // 랜덤 인덱스의 값이 기존 값 +1로 변경 확인
        assertEquals(expected, given.get(givenIndex));
    }

    @Test
    public void deleteByIndex2() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0~99까지 값 입력
        for (int i = 0; i < 100; i++){
            given.add(i);
        }
        // 98번 인덱스 노드 삭제
        given.deleteByIndex(98);
        // 98번 인덱스 값 99 확인
        assertEquals(99, given.get(98));

        // 1번 인덱스 노드
        given.deleteByIndex(1);
        // 1번 인덱스 값 2 확인
        assertEquals(2, given.get(1));
    }
    
    @Test
    public void delete() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        // 0 ~ 99 까지 값 추가
        for (int i = 0; i <100; i++){
            given.add(i);
        }
        // 사이즈 100 확인
        assertEquals(100, given.size());
        Random random = new Random();
        // 랜덤 값 0~98 범위
        Integer target = random.nextInt(99);
        // 값 포함 확인
        assertTrue(given.contains(target));
        // 값의 인덱스 = 값
        assertEquals(target, given.indexOf(target));
        // 값 삭제
        given.delete(target);
        // 사이즈 1 감소 확인
        assertEquals(99, given.size());
        // 값 미포함 확인
        assertFalse(given.contains(target));
        // 값으로 인덱스 검색시 -1 반환 확인
        assertEquals(-1, given.indexOf(target));
    }
}
