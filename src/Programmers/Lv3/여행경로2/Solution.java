package Programmers.Lv3.여행경로2;

import java.util.*;
class Solution {
    static List<String> paths = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] usedTickets = new boolean[tickets[0].length];

        DFS("ICN","",usedTickets,tickets);
        return answer;
    }


    public static void DFS(String cur,String path,boolean[] usedTickets, String[][] tickets){

        if(allUsedTicket(usedTickets)){
            System.out.println(path);
            paths.add(path);
            return;
        }

        path+=cur+" ";
        for (int i=0; i<tickets.length; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];

            if(!usedTickets[i] && cur.equals(start)){
                usedTickets[i]=true;
                DFS(end,path,usedTickets,tickets);
                usedTickets[i]=false;
            }
        }


    }

    public static boolean allUsedTicket(boolean[] usedTickets){

        for (int i=0; i<usedTickets.length; i++){
            if(!usedTickets[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
    }
}
