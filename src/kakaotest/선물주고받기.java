package kakaotest;

import java.util.HashMap;
import java.util.Scanner;

public class 선물주고받기 {
    static boolean[] check;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        check = new boolean[friends.length];
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();// 본체 map

        HashMap<String,Integer> giveMap = new HashMap<>();
        HashMap<String,Integer> takeMap = new HashMap<>();

        HashMap<String,Integer> answerMap = new HashMap<>();
        HashMap<String, Integer> ScoreMap = new HashMap<>();
        HashMap<String,Integer> idxMap = new HashMap<>();

        HashMap<String,Integer> map2 = new HashMap<>();
        for (int i=0; i<friends.length; i++){
            map.put(friends[i],new HashMap<String,Integer>());
            ScoreMap.put(friends[i],0);
            giveMap.put(friends[i],0);
            takeMap.put(friends[i],0);
            idxMap.put(friends[i],i );

        }


        for (int i=0; i<gifts.length; i++){
            String info = gifts[i];
            String[] giveAndTake = info.split(" ");
            String giver = giveAndTake[0];
            String taker = giveAndTake[1];
            giveMap.put(giver, giveMap.get(giver)+1);
            takeMap.put(taker, takeMap.get(taker)+1);

            map.get(giver).put(taker, map.get(giver).getOrDefault(taker,0)+1);
        }


        //선물지수 계산
        for (int i=0; i< friends.length; i++){
            ScoreMap.put(friends[i],giveMap.get(friends[i])-takeMap.get(friends[i]));
        }



        //서로 주고받은거 확인
        //1. 두 사람이 선물을 주고받은 기록이 있다!
        //- 서로 선물을 더 많이 준사람이 당연히 받아야지 다음달~

        //2. 두 사람이 선물을 주고받은 기록이 없다! , 주고받은 수가 같다!
        //- 선물 지수가 더 큰사람이 작은사람에게 받는다 . 선물지수 = (준 갯수 - 받은갯수)
        //- 두사람의 선물지수도 같다면 추가안한다 .

        for (int i=0; i< friends.length; i++){
            String giver = friends[i];

            HashMap<String, Integer> receiverMap = map.get(giver);  //muzi frodo 2

            for (int j=i; j< friends.length; j++){
                String to = friends[j];
                if(to.equals(giver)) continue;

                if(!receiverMap.containsKey(to)){
                    //neo 기준 frodo랑 ryan
                    HashMap<String, Integer> toMap = map.get(to);
                    if(!toMap.containsKey(giver)){ //서로가 주고받지않았다면
                        //선물지수확인
                        if(ScoreMap.get(giver)>ScoreMap.get(to)){
                            answerMap.put(giver, answerMap.getOrDefault(giver, 0) + 1);
                        } else if (ScoreMap.get(giver)<ScoreMap.get(to)){
                            answerMap.put(to, answerMap.getOrDefault(to, 0) + 1);
                        }
                    }

                }
            }
            for(String taker: receiverMap.keySet()){
                int giverToTaker = receiverMap.get(taker); //muzi->frodo 2개

                HashMap<String, Integer> takerToGiveMap = map.get(taker);

                if(takerToGiveMap.containsKey(giver)){ //양방향으로 주고받았다면 자식도 체크
                    if(check[idxMap.get(taker)]) continue;
                    int takerTogiver = takerToGiveMap.get(giver);


                    if(giverToTaker>takerTogiver){
                        answerMap.put(giver, answerMap.getOrDefault(giver, 0) + 1);
                    } else if (giverToTaker<takerTogiver){
                        answerMap.put(taker, answerMap.getOrDefault(taker, 0) + 1);
                    } else { //같으면 선물지수확인
                        if(ScoreMap.get(giver)>ScoreMap.get(taker)){
                            answerMap.put(giver, answerMap.getOrDefault(giver, 0) + 1);
                        } else if (ScoreMap.get(giver)<ScoreMap.get(taker)){
                            answerMap.put(taker, answerMap.getOrDefault(taker, 0) + 1);
                        }
                    }

                } else { //giver만 줬다면 giver ++
                    answerMap.put(giver, answerMap.getOrDefault(giver, 0) + 1);
                }

            }

            check[i]=true;

        }


        for(String key: answerMap.keySet()){
            answer = Math.max(answer,answerMap.get(key));
        }

        return answer;
    }
    public static void main(String[] args) {
        선물주고받기 main = new 선물주고받기();
        main.solution(new String[]{"muzi", "ryan", "frodo", "neo" }, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi" });
    }
}
