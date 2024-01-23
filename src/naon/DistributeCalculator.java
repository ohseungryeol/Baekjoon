package naon;

public class DistributeCalculator implements Calculator{
    @Override
    public long calc(long[] arr) {
        int n = arr.length;
        // 평균값 계산
        long sum = 0;
        for (long num : arr) {
            sum += num;
        }
        long mean = sum / n;

        // 편차를 제곱한 값의 합계 계산
        long sumOfSquaredDeviations = 0;
        for (long num : arr) {
            long deviation = num - mean;
            sumOfSquaredDeviations += deviation * deviation;
        }

        return sumOfSquaredDeviations;
    }
}
