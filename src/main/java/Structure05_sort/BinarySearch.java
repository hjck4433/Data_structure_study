package Structure05_sort;

public class BinarySearch {
    public int search(int[] arr, int target){
        // 1. 데이터의 중간 인덱스 값을 찾는다
        // 2. 중간 인덱스 위치를 기준으로 arr 을 절반으로 나눈다.
        // 3. 나눠진 절반의 리스트에서 target 값을 찾는다

        int l = 0;
        int r = arr.length-1;

        int m;
        while(l <= r){
            // l, r 이 int의 범위에 있더라도 더하면 벗어날 수 있음
            // 왼쪽에 두 값 사이의 차이값의 절반을 더하면 l, r 사이의 중간값이 되면서
            // 범위 초과를 방지할 수 있음
            m = l + ((r - l) /2);

            // 중간 값이 목표 값이라면 반환
            if(arr[m] == target) {
                return m;
            }
            // 목표값이 더 크다면
            if (arr[m] < target) {
                // 시작 위치를 이동
                l = m + 1;
            }else {
                // 반대의 경우 끝 위치를 이동
                r = m -1;
            }
        }

        return -1;
    }
}
