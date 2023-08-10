package Programmers.Lv1;

import java.util.Stack;

public class 햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<ingredient.length; i++){
            stack.push(ingredient[i]);
            int index = stack.size()-1;
            if(index>=3){
                if(sequence_o(stack,index)){
                    answer++;
                    stack.pop(); stack.pop(); stack.pop(); stack.pop();
                }
            }
        }

        //System.out.println(answer);
        return answer;
    }

    public boolean sequence_o(Stack<Integer> stack, int index){
        if(stack.get(index)==1 && stack.get(index-1)==3 && stack.get(index-2)==2 && stack.get(index-3)==1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        햄버거만들기 main = new 햄버거만들기();
        main.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1});
    }
}
