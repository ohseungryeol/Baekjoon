package Programmers.Lv3.입국심사;

import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int len = times.length-1;
        // 더 빨리 끝내주는 심사관한테 가서 심사를 받는다.

        int left =0;
        int right= times[len]*n;

        while(left<=right){
            int mid = (left + right) / 2;
            int sum=0;

            for(int time:times){
                // mid 시간동안 몇명을 심사할 수 있는가
                sum+=mid/time;
            }

            // n명보다 적으면 범위를 올림.
            if(sum<=n){
                left = mid+1;
            } else if(sum==n){
                answer = mid;
                break;
            } else{
                right = mid-1;
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(6, new int[]{7, 10});
    }
}
