package Programmers.Lv2.택배상자;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx =0;
        for (int i=1; i<=order.length; i++){
            if(i==order[idx]){
                answer++;
                idx++;

                while(!stack.isEmpty()){
                    if(stack.peek()==order[idx]){
                        idx++;
                        answer++;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                continue;
            }

            stack.add(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(new int[]{3,5,4,2,1});
    }
}
