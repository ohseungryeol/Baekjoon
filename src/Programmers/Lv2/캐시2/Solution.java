package Programmers.Lv2.캐시2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        //캐시가 비어있고
        if(cacheSize==0){
            answer = 5* cities.length;
        } else {
            for (String str : cities) {
                str = str.toLowerCase();
                if (queue.size() < cacheSize) {
                    if (queue.contains(str)) { //캐시 히트
                        answer += 1;
                        queue.remove(str);
                        queue.offer(str);
                    } else {
                        queue.offer(str);
                        answer += 5;
                    }
                } else if (queue.size() == cacheSize) {
                    if (queue.contains(str)) { //히트
                        answer += 1;
                        queue.remove(str);
                        queue.offer(str);
                    } else { //미스
                        answer += 5;
                        queue.poll();
                        queue.offer(str);
                    }
                }
            }

//            for (String str:cities){
//                str = str.toLowerCase();
//                if(queue.size())
//            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Pangyo", "Jeju", "Seoul", "Jeju", "Pangyo", "Seoul"});
    }
}
