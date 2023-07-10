package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class 달리기경주 {
    public static void main(String[] args) {
        달리기경주 달리기경주 = new 달리기경주();

        System.out.println(Arrays.toString(달리기경주.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "mine", "mine"})));
    }

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = new String[players.length];

        for (int i=0; i< players.length; i++){
            map.put(players[i],i);
        }

        for (int i=0; i<callings.length; i++){
            String cur = callings[i]; //현재 달리는 선수
            int curIdx = map.get(cur);
            String front = players[curIdx-1]; //현재 앞에 달리고 있는 선수
            int frontIdx = map.get(front);
           // System.out.printf("cur=%s, curIdx=%d, front=%s, frontIdx=%d\n",cur,curIdx,front,map.get(front));
            // cur과 front의 위치를 교환한다.
            map.put(cur,frontIdx);
            map.put(front,curIdx);

            players[curIdx]=front;
            players[frontIdx]=cur;
        }

        Set<String> keySet = map.keySet();

        for (String key: keySet){
            //System.out.println(key+","+map.get(key));
            answer[map.get(key)]=key;
        }

        return answer;
    }
}
