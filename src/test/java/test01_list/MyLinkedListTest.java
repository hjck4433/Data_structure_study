package test01_list;

import Structure01_List.IList;
import Structure01_List.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    @Test
    public void add() {
        IList<Integer> given = new MyLinkedList<>();
        // 0~49 까지 추가
        for (int i = 0; i < 50; i++){
            given.add(i);
            // 값이 추가 될 때마다 사이즈 증가 확인
            assertEquals(i+1, given.size());
            // 인덱스에 값 확인 / 인덱스 0의 값 0 ...
            assertEquals(i, given.get(i));
        }
        // 인덱스 10에 값(999) 추가
        given.insert(10, 999);
        // 사이즈 51로 늘어나는 것 확인
        assertEquals(51, given.size());
        // 10번 인덱스의 값 999 확인
        assertEquals(999, given.get(10));
        // 47번 인덱스에 값(998) 추가
        given.insert(47, 998);
        // 사이즈 52로 증가 확인
        assertEquals(52, given.size());
        // 값 998의 인덱스 47 확인
        assertEquals(47, given.indexOf(998));
    }

    @Test
    public void insert() {
        IList<Integer> given = new MyLinkedList<>();
        // 값 추가
        given.add(9);
        given.add(8);
        given.add(7);
        // 0번 인덱스에 값(1) 추가
        given.insert(0,1);
        // 사이즈 4 확인
        assertEquals(given.size(), 4);
        // 0번 인덱스 값 1 확인
        assertEquals(1, given.get(0));
    }
    
    @Test
    public void indexOf() {
        IList<Integer> given = new MyLinkedList<>();
        // 0~49까지 값 추가
        for (int i = 0; i < 50; i++) {
            given.add(i);
        }
        // 0번 인덱스 부터 인덱스 = 값 일치 확인
        for (int i = 0; i < 50; i++) {
            int idx = given.indexOf(i);
            assertEquals(i,idx);
        }
    }

    @Test
    public void insert2() {
        // insert로 add와 같은 조건 테스트
        IList<Integer> given = new MyLinkedList<>();
        // 0번 인덱스에 값 1 추가
        given.insert(0, 1);
        // 사이즈 확인
        assertEquals(1, given.size());

        // 1번 인덱스에 값 2 추가
        given.insert(1,2);
        // 사이즈 확인
        assertEquals(2, given.size());

        // 0번 인덱스 - 1 / 1번 인덱스 -2 확인
        assertEquals(1, given.get(0));
        assertEquals(2, given.get(1));
    }

    @Test
    public void insert_exception() {
        // 2번 인덱스에 값을 추가하려면 1번 인덱스가 존재하여야 함
        IList<Integer> given = new MyLinkedList<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            given.insert(2,1);
        });
    }

    @Test
    public void clear() {
        IList<Integer> given = new MyLinkedList<>();
        // 0~99까지 값 추가
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        // 사이즈 100 확인
        assertEquals(100, given.size());
        // 값이 있으므로 isEmpty는 false 확인
        assertFalse(given.isEmpty());
        // 초기화
        given.clear();
        // 초기화 후 사이즈 0 확인
        assertEquals(0, given.size());
        // 초기화 후 isEmpty는 true 확인
        assertTrue(given.isEmpty());
    }
    
    @Test
    public void deleteByIndex() {
        IList<Integer> given = new MyLinkedList<>();
        // 0~99 까지 값 추가
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        Random random = new Random();
        // 랜덤으로 인덱스 부여 (0~98 범위)
        int givenIndex = random.nextInt(99);
        // 삭제 후 해당 인덱스 위치에 예상되는 값
        int expected = given.get(givenIndex + 1);
        // 인덱스로 삭제
        given.deleteByIndex(givenIndex);
        // 확인
        assertEquals(expected, given.get(givenIndex));
    }
    
    @Test
    public void delete() {
        IList<Integer> given = new MyLinkedList<>();
        // 0 ~ 99 까지 값 추가
        for (int i = 0; i < 100; i++){
            given.add(i);
        }
        // 사이즈 100 확인
        assertEquals(100,given.size());
        Random random = new Random();
        // 랜덤으로 인덱스 부여 (0~98 범위)
        Integer target = random.nextInt(99);
        // 삭제하기 전이므로 값 존재 확인
        assertTrue(given.contains(target));
        // 인덱스와 인덱스 값 일치 /ex) 20인덱스 - 20 
        assertEquals(target, given.indexOf(target));
        // 값으로 삭제
        given.delete(target);
        // 삭제 후 사이즈 1 감소 확인
        assertEquals(99, given.size());
        // 삭제 후 값 부존재 확인
        assertFalse(given.contains(target));
        // 삭제 후 값에 해당하는 인덱스 검색 시 -1 반환 확인
        assertEquals(-1, given.indexOf(target));
    }
}
