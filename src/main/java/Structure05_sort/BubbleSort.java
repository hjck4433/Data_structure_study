package Structure05_sort;

public class BubbleSort implements ISort{

    @Override
    public void sort(int[] arr) {
         // 안정 정렬
        // 인플레이스 정렬
        for (int i = 0; i < arr.length -1; i++){
            for(int j = 0; j < arr.length -1 -i; j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
