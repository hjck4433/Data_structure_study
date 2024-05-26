package test05_sort;

import Structure05_sort.BubbleSort;
import Structure05_sort.InsertionSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest extends BaseSortTest {
    private BubbleSort bubbleSort = new BubbleSort();
    private InsertionSort insertionSort = new InsertionSort();

    @Test
    void bubbleSort() {
        for (int i = 1; i < 100; i++) {
            // 무작위의 숫자가 들어간 배열 생성
            int[] arr = createRandomArray(i);
            // 배열 복사
            int[] expected = Arrays.copyOf(arr, arr.length);
            // 복사한 배열 정렬
            Arrays.sort(expected);
            // 버블정렬를 이용하여 정렬
            bubbleSort.sort(arr);
            // 버블정렬이 성공적으로 되었는지 확인
            assertArrayEquals(expected, arr);
        }
    }

    @Test
    void insertionSort() {
        for (int i = 1; i < 100; i++){
            // 버블 정렬의 테스트 방식과 동일
            int[] arr = createRandomArray(i);
            int[] expected = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expected);
            insertionSort.sort(arr);
            assertArrayEquals(expected, arr);
        }
    }
}
