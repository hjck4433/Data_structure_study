package test05_sort;

import java.util.Random;

public class BaseSortTest {
    protected int[] createRandomArray(int size) {
        int[] ret = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++){
            // 사이즈를 벗어나지 않는 범위의 수가 무작위로 저장
            ret[i] = random.nextInt() % size;
        }
        return ret;
    }
}
