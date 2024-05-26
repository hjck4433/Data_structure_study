package test04_hashtable;

import Structure04_HashTable.IHashTable;
import Structure04_HashTable.MyLinkedHashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashTableTest {
    @Test
    public void put() {
        IHashTable<String, Integer> given = new MyLinkedHashTable<>(3);
        // 리스트에 key value 쌍 추가
        given.put("hello",1);
        given.put("world",3);
        given.put("korea", 10);
        given.put("awesome", 5);
        given.put("data", 3);
        given.put("hard", 111);

        // 총 사이즈 확인
        assertEquals(6, given.size());
        // 각각의 key로 존재 여부 및 값 확인
        assertTrue(given.contains("hello"));
        assertEquals(1, given.get("hello"));
        assertTrue(given.contains("world"));
        assertEquals(3, given.get("world"));
        assertTrue(given.contains("korea"));
        assertEquals(10,given.get("korea"));
        assertTrue(given.contains("awesome"));
        assertEquals(5, given.get("awesome"));
        assertTrue(given.contains("data"));
        assertEquals(3, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(111, given.get("hard"));
    }

    @Test
    public void delete() {
        IHashTable<String, Integer> given = new MyLinkedHashTable<>(3);
        given.put("hello", 1);
        given.put("world", 3);
        given.put("korea", 10);
        given.put("awesome", 5);
        given.put("data", 3);
        given.put("hard", 111);

        // 사이즈 확인
        assertEquals(6, given.size());
        // world 삭제
        given.delete("world");
        // 사이즈 감소 확인
        assertEquals(5, given.size());
        assertTrue(given.contains("hello"));
        assertEquals(1, given.get("hello"));
        // world가 없는 것 확인
        assertFalse(given.contains("world"));
        // 값 요청 시 null 확인
        assertNull(given.get("world"));
        assertTrue(given.contains("korea"));
        assertEquals(10, given.get("korea"));
        assertTrue(given.contains("awesome"));
        assertEquals(5, given.get("awesome"));
        assertTrue(given.contains("data"));
        assertEquals(3, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(111, given.get("hard"));
    }

    @Test
    public void update() {
        IHashTable<String, Integer> given = new MyLinkedHashTable<>(3);
        given.put("hello", 1);
        given.put("world", 3);
        given.put("korea", 10);
        given.put("awesome", 5);
        given.put("data", 3);
        given.put("hard", 111);

        // 사이즈 & 처음 입력 값 확인
        assertEquals(6, given.size());
        assertTrue(given.contains("hello"));
        assertEquals(1, given.get("hello"));
        assertTrue(given.contains("world"));
        assertEquals(3, given.get("world"));
        assertTrue(given.contains("korea"));
        assertEquals(10, given.get("korea"));
        assertTrue(given.contains("awesome"));
        assertEquals(5, given.get("awesome"));
        assertTrue(given.contains("data"));
        assertEquals(3, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(111, given.get("hard"));

        // data, hard 새로운 값 입력
        given.put("data", 95);
        given.put("hard", 0);
        // 각각 key 존재 확인 및 변경 된 값 반환 확인
        assertTrue(given.contains("data"));
        assertEquals(95, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(0, given.get("hard"));
        assertEquals(6, given.size());
    }
}
