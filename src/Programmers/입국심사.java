package Programmers;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        입국심사 입국심사 = new 입국심사();
        int n=6;
        int[] times = {7, 10};
        System.out.println(입국심사.solution(n,times));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = times[0];
        long answer = 0;
        long end = (long)times[times.length-1]*n;

        while(start<=end){
            long mid = (start + end) / 2;
            long sum=0;
            for (int time:times){
                sum+=mid/time;
            }
            if(sum<n){
                start=mid+1;
            } else{
                answer = Math.min(answer, mid);
                end = mid-1;
            }
        }

        return answer;
    }

}
