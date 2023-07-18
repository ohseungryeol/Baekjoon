package Programmers.Lv2;

import java.util.*;

public class 귤고르기 {

    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num: tangerine){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Integer[] arr = new Integer[map.size()];

        int j=0;
        for (int key: map.keySet()){
           // System.out.printf("key = %d, value = %d\n",key,map.get(key));
            arr[j++]=map.get(key);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int i=0;
        int answer = 0;

        while(true){
            k-=arr[i++];
            answer++;
            if(k<=0) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        귤고르기 a = new 귤고르기();
        System.out.println(a.solution(6,new int[] {1, 3, 2, 5, 4, 5, 2, 3}));

    }
}
