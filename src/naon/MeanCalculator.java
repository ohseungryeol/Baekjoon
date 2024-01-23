package naon;

public class MeanCalculator implements Calculator{
    @Override
    public long calc(long[] arr) {
        // 버블정렬 코드
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        int length = arr.length;

        // 배열의 길이가 홀수인 경우
        if (length % 2 == 1) {
            return arr[length / 2];
        }

        // 배열의 길이가 짝수인 경우
        int middleIndex = length / 2;
        return (arr[middleIndex - 1] + arr[middleIndex]) / 2;

    }
}
