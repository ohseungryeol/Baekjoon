package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class 연속된부분수열합 {
    public int[] solution(int[] sequence, int k) {
        ArrayList<int[]> answer = new ArrayList<>();
        int[] a = {};
        int left=0;
        int right=0;
        int partSum =sequence[0];
        int n = sequence.length;
        while(true){
            System.out.printf("left =%d right= %d\n",left,right);
            if(partSum<k){
                right++;
                if(right<n) partSum+=sequence[right];
            }

            if(partSum==k){
               answer.add(new int[] {left,right});
               right++;
               if(right<n){
                   partSum+=sequence[right];
               }
            }
            if(left==n || right == n) break;
            if(partSum>k){
                partSum-=sequence[left];
                if(left<n) left++;
            }


        }
        for(int[] ans: answer){
            System.out.println(Arrays.toString(ans));
        }

        return a;
    }

    public static void main(String[] args) {
        int k=5;
        int[] sequence = {1,1,1,2,3,4,5};
        연속된부분수열합 연속된부분수열합 = new 연속된부분수열합();
        연속된부분수열합.solution(sequence,7);
    }
}
