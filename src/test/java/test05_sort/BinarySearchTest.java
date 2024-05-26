package test05_sort;

import Structure05_sort.BinarySearch;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest extends BaseSortTest{
    BinarySearch bs = new BinarySearch();

    @Test
    void search() {
        Random random = new Random();
        // 길이가 100, 무작위로 생성된 숫자를 정렬하여 리스트에 담음
        List<Integer> randomList = Arrays.stream(this.createRandomArray(100))
                .boxed().sorted().collect(Collectors.toList());
        // 리스트를 배열로 저장
        int[] randomArr = randomList.stream().mapToInt(Integer::intValue).toArray();

        for(int i = 0; i < 100; i ++) {
            // 0~99 사이의 인덱스에 위치 한 값을 목표로 함
            int target = randomList.get(random.nextInt(randomList.size()));
            // 이진 탐색을 통해 해당 값의 인덱스를 반환 받음
            int result = bs.search(randomArr, target);
            // 인덱스를 매개변수로 리스트에 값 요청시 목표 값 반환 확인
            assertEquals(randomList.get(result), target);
        }
    }
}
