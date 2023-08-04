package Programmers.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }

        for (int i=0; i<photo.length; i++){
            String[] album = photo[i];
            for(String person:album){
                if(map.containsKey(person)) {
                    answer[i] += map.get(person);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        추억점수 추억점수 = new 추억점수();
        System.out.println(Arrays.toString(추억점수.solution(new String[]{"may", "kein", "kain", "radi"},new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})));

    }
}
