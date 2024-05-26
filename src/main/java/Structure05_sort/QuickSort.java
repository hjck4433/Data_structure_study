package Structure05_sort;

public class QuickSort implements ISort{
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
    private void quickSort(int[] arr, int low, int high){
        if (low >= high) {
            return;
        }
        // pivot 인덱스
        int pivot = low +((high - low) / 2);
        // pivot 인덱스의 값
        int pivotValue = arr[pivot];

        int left = low;
        int right = high;

        // pivot값을 기준으로 작으면 왼쪽 크면 오른쪾
        while(left <= right) {
            // 왼쪽의 값이 이미 pviot값 보다 작으면 이동 필요 x
            // left만 증가
            while(arr[left] < pivotValue){
                left++;
            }

            // 오른쪽의 값이 이미 pviot값 보다 크면 이동 필요 x
            // right만 감소
            while(arr[right] > pivotValue){
                right--;
            }

            // 왼쪽과 오른쪽이 교차 하지 않았다면 왼쪽 값과 오른쪽 값 교환
            // 마지막 left와 right의 값이
            // pviot보다 작거나 큰 값이 아니었기 때문에 교차하지 않은 것
            if(left <= right){
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] =tmp;
                left++;
                right--;
            }
        }

        // 왼쪽으로 다시 호출
        quickSort(arr, low, right);
        // 오른쪽으로 다시 호출
        quickSort(arr, left, high);
    }
}
