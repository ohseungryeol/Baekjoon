package Programmers.Lv2.시소짝궁;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int len = weights.length;

        //HashSet<Integer> set = new HashSet<>();
        // 2,3,4, 균형

        for (int i=0; i<len; i++){
            int p2 = i+1;
            HashSet<Integer> set = new HashSet<>();
            for (int j=1; j<=4; j++){
                set.add(weights[i]*j);
            }

            while(p2<len){
                for (int j=1; j<=4; j++){
                    int comp = weights[p2]*j;
                    if(set.contains(comp)){
                        answer++;
                        break;
                    }
                }
                p2++;
            }
        }



        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(new int[]{100, 180, 360, 100, 270});
    }
}
