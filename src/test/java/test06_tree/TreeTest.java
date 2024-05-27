package test06_tree;

import Structure06_tree.BinarySearchTree;
import Structure06_tree.ITree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {
    @Test
    public void basic() {
        // 트리에 값 삽입
        ITree<Integer> given = new BinarySearchTree<>();
        given.insert(3); // 루트가 됨
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        // 사이즈 확인 / 값 존재 확인
        assertEquals(5, given.size());
        assertTrue(given.contains(0));
        assertTrue(given.contains(1));
        assertFalse(given.contains(2));
        assertTrue(given.contains(3));
        assertTrue(given.contains(4));
        assertTrue(given.contains(5));

        // 존재하는 값(5,0), 존재하지 않는 값(-1, 10) 삭제 시도
        given.delete(5);
        given.delete(0);
        given.delete(-1);
        given.delete(10);
        // 총 2개의 값만 삭제 확인
        // 사이즈 5 -> 3
        assertEquals(3, given.size());
        // 삭제한 값이 0, 5 false 반환 확인
        // 나머지 true 반환 확인
        assertFalse(given.contains(0));
        assertTrue(given.contains(1));
        assertFalse(given.contains(2));
        assertTrue(given.contains(3));
        assertTrue(given.contains(4));
        assertFalse(given.contains(5));
    }

    @Test
    public void inorder() {
        // 값 추가
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3); // root
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        // 중위 탐색 결과 확인
        List<Integer> visited = given.inOrder();
        assertEquals(5, visited.size());
        // 중위 순회하여 정렬되어 값이 리스트에 담겨 있음
        // 왼->가운데->오 (작은 값 / 중간 값 /큰 값 => 정렬이 되는 것)
        assertEquals(List.of(0, 1, 3, 4, 5), visited);
    }

    @Test
    public void preorder() {
        // 값 추가
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3); // root
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        // 전위 탐색 결과 확인
        List<Integer> visited = given.preOrder();
        assertEquals(5, visited.size());
        // root를 시작으로 값이 리스트에 담김
        // 가운데 -> 왼 -> 오
        assertEquals(List.of(3, 1, 0, 5, 4), visited);
    }

    @Test
    public void postorder() {
        // 값 추가
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3); // root
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        // 후위 탐색 결고 확인
        List<Integer> visited = given.postOrder();
        assertEquals(5, visited.size());
        // root가 마지막으로 값이 리스트에 담김
        // 왼->오->가운데
        assertEquals(List.of(0, 1, 4, 5, 3), visited);
    }

    @Test
    public void min() {
        // 값 추가
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);
        given.insert(-1);

        // 가장 작은 값 결과 -1 확인
        // 왼쪽으로 계속 탐색해 나감
        assertEquals(-1, given.min());
    }

    @Test
    public void max() {
        // 값 추가
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);
        given.insert(10);
        given.insert(15);

        // 가장 큰 값 15 확인
        // 오른쪽으로 계속 탐색해 나감
        assertEquals(15, given.max());
    }
}
