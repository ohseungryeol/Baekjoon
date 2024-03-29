package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        //cash hit = 1 cash miss 10
        if(cacheSize==0){
            answer= 5*cities.length;
        } else {
            for (int i = 0; i < cities.length; i++) {
                cities[i] = cities[i].toLowerCase();
                if (queue.size() < cacheSize) {
                    if(queue.contains(cities[i])){
                        answer+=1;
                        queue.remove(cities[i]);
                        queue.offer(cities[i]);
                    }
                    else{
                        queue.offer(cities[i]);
                        answer+=5;
                    }
                } else {
                    if (queue.contains(cities[i])) { //cash hit
                        answer += 1;
                        queue.remove(cities[i]);
                        queue.offer(cities[i]);
                    } else { //cash miss
                        answer += 5;
                        queue.poll();
                        queue.offer(cities[i]);
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        캐시 main = new 캐시();
        main.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});


    }
}
