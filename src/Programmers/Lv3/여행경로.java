package Programmers.Lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 여행경로 {
    static HashMap<String, String> map = new HashMap<>();
    static boolean[] visited;
    static boolean flag=true;
    static String route = "";
    static ArrayList<String> rouths = new ArrayList<>();
    public String[] solution(String[][] tickets) {

        for(int i=0; i< tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                visited = new boolean[tickets.length];
                route="ICN ";
                visited[i]=true;
                DFS(i,"ICN",tickets);
                rouths.add(route);
            }
        }
        for(int i=0; i<rouths.size(); i++){
            System.out.println(rouths.get(i));
        }
        Collections.sort(rouths);
        String str = rouths.get(0);
        String[] answer = str.split(" ");
        //주어진 항공권 모두 사용
        //가능 경로가 2개 이상이면 알파벳 순서가 앞서는 경로 우선
        return answer;
    }

    public void DFS(int L, String start, String[][] tickets){
        //answer 사전순 비교 로직
        String next = tickets[L][1];
        route+=next+" ";

        for (int i=0; i< tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(next)){
                visited[i]=true;
                DFS(i,tickets[i][0],tickets);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        여행경로 main = new 여행경로();
        main.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
    }
}
