package Structure05_sort;

public class InsertionSort implements ISort{
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            int key = arr[i]; // 삽입 위치를 찾아줄 데이터
            int j = i -1; // 0-j 정렬된 서브 리스트
            // j가 0이상 이고 키가 arr[j] 보다 작은 동안
            while(j >= 0 && arr[j] > key) {
                arr[j +1] = arr[j];
                j = j -1;
            }
            arr[j + 1] = key;
        }
    }
}
