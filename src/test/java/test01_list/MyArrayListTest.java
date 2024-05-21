package test01_list;

import Structure01_List.IList;
import Structure01_List.MyArrayList;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    @Test
    public void add() {
        IList<Integer> given = new MyArrayList<>();
        // 0~49 까지 추가
        for(int i = 0; i < 50; i++) {
            given.add(i);
            // 값이 추가 될 때마다 사이즈 1 증가 확인
            assertEquals(i + 1, given.size());
            // 0 - 0인덱스 / 1 - 1인덱스 ....
            assertEquals(i, given.get(i));
        }
    }

    @Test
    public void clear() {
        IList<Integer> given = new MyArrayList<>();
        // 0~99까지 추가
        for(int i = 0; i < 100; i++) {
            given.add(i);
        }
        // 총 길이 100 확인 
        assertEquals(100, given.size());
        // 값이 있으므로 isEmpty false 확인
        assertFalse(given.isEmpty());
        // 비우기
        given.clear();
        // 비우기 이후 사이즈 0 확인
        assertEquals(0, given.size());
        // 값이 없으므로 isEmpty true 확인
        assertTrue(given.isEmpty());
    }

    @Test
    public void deleteByIndex() {
        IList<Integer> given = new MyArrayList<>();
        // 0~99까지 추가
        for(int i = 0; i < 100; i++) {
            given.add(i);
        }
        // 총 길이 100 확인
        assertEquals(100, given.size());
        Random random = new Random();
        // 삭제할 인덱스 - 범위(0~98)
        int givenIndex = random.nextInt(99);
        // 삭제할 인덱스 바로 뒤의 값
        int expected = given.get(givenIndex + 1);
        // 인덱스로 값 삭제
        given.deleteByIndex(givenIndex);
        // 삭제 후 뒤에 있던 값이 한 칸 앞으로 이동 되었는지 확인
        assertEquals(expected, given.get(givenIndex));
    }

    @Test
    public void delete() {
        IList<Integer> given = new MyArrayList<>();
        // 0~99 까지 추가
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        // 총 길이 100 확인
        assertEquals(100, given.size());
        Random random = new Random();
        // 삭제할 값 - 범위(0~98)
        Integer target = random.nextInt(99);
        // 삭제 전이므로 리스트에 목표 값 존재
        assertTrue(given.contains(target));
        // 삭제 전이므로 목표 값은 그 값의 인덱스에 위치함
        assertEquals(target, given.indexOf(target));
        // 목표 값 삭제
        given.delete(target);
        // 삭제 후 총 길이 99 확인
        assertEquals(99, given.size());
        // 삭제 되었으므로 목표 값 리스트에 없음
        assertFalse(given.contains(target));
        // 리스트에 해당 값 없으므로 -1 반환 확인
        assertEquals(-1, given.indexOf(target));
    }
}
