package Structure05_sort;

public class MergeSort implements ISort{
    @Override
    public void sort(int[] arr) {
        // in-place sort
        mergeSort(arr, 0, arr.length-1);
    }

    // 분할
    private void mergeSort(int[] arr, int low, int high){
        if (low >= high) {
            return;
        }
        int mid = low + ((high -low ) / 2);
        // 왼쪽 반
        mergeSort(arr, low, mid);
        // 오른쪽 반
        mergeSort(arr, mid+1, high);

        // 병합
        merge(arr, low, mid, high);
    }

    // 합병
    private void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high -low + 1];
        int idx = 0;

        int left = low;
        int right = mid + 1;
        // 왼쪽이 중간 이하이고 오른쪽이 최대 이하인 동안
        while(left <= mid && right <= high){
            // 왼쪽의 값이 작으면 temp 배열에 추가
            // 다음 왼쪽 값이 비교대상이 될수 있도록 값 증가
            if(arr[left] <= arr[right]){
                temp[idx] = arr[left];
                left++;
            }else {
                // 오른쪽쪽의 값이 작으면 temp 배열에 추가
                // 다음 오른쪽 값이 비교대상이 될수 있도록 값 증가
                temp[idx] = arr[right];
                right++;
            }
            // 인덱스 증가
            idx++;
        }

        // 왼쪽의 값이 남아 있는 경우 인덱스 값과 왼쪽의 값을 증가하며 temp배열에 차례로 대입
        while(left <= mid) {
            temp[idx] = arr[left];
            idx++;
            left++;
        }
        // 오른쪽의 값이 남아 있는 경우 인덱스 값과 왼쪽의 값을 증가하며 temp배열에 차례로 대입
        while(right <= high) {
            temp[idx] = arr[right];
            idx++;
            right++;
        }
        // 배열에 순서대로 다시 값 대입
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i- low];
        }
    }
}
