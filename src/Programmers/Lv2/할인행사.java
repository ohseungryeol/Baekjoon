package Programmers.Lv2;

import java.util.HashMap;

public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) map.put(want[i], number[i]);

        for (int i=0; i< discount.length-10; i++){
            for (int j=i+1; j<=i+9; j++){

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        할인행사 main = new 할인행사();
        main.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
        );


    }
}
