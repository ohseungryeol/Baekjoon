package 알고리즘고득점Kit.탐색.여행경로;

import java.util.*;
class Solution {
    static ArrayList<String> answer = new ArrayList<>();
    static HashMap<String,ArrayList<String>> map = new HashMap<>();
    static HashMap<String,boolean[] > checkmap = new HashMap<>();
    static int tL ;

    public ArrayList<String> solution(String[][] tickets) {
        tL = tickets.length;
        boolean[] check = new boolean[tickets.length];
        for (String[] ticket: tickets){
            String start = ticket[0];
            String end = ticket[1];

            ArrayList<String> endList = new ArrayList<>();
            // 초기화
            if(map.get(start)==null){
                endList.add(end);
                map.put(start,endList);
            } else { //이미 출발지점이 존재하면 새로 추가
                map.get(start).add(end);
            }


        }
// 출발 지점 당 도착지점 체크 배열 추가
        for (String key:map.keySet()){
            //boolean[] check = new boolean[map.get(key).size()];
            checkmap.put(key,check);
        }
        //알파벳 순 정렬
        for (String key:map.keySet()){
            ArrayList<String> endList = map.get(key);
            if(endList.size()>=2){
                Collections.sort(endList);
            }
        }


        DFS("ICN",0,tickets,true);
        for (int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
        return answer;

    }

    public static void DFS(String start,int L,String[][] tickets, boolean flag){
        if(L==tL){
            return;
        }

        answer.add(start);
        // 출발지점 도착지 리스트 순회
        boolean[] endCheck = checkmap.get(start);
        if(map.get(start)==null && L<tL){
            answer.clear();
            flag =false;
            return;
        }
        ArrayList<String> endList = map.get(start);


        for (int i=0; i<map.get(start).size(); i++){
            if(!endCheck[i] && flag){ //방문 안한 도착지라면
                endCheck[i]=true;
                DFS(endList.get(i),L+1,tickets,flag);
                endCheck[i]=false;
            }
        }


    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(new String[][]{{"ICN","B"},{"B","ICN"},{"ICN","A"},{"A","D"},{"D","A"}});
    }
}
