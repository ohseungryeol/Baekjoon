package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Collections;

public class 피로도 {
    static int answer =0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        DFS(0,dungeons, k,0);
        System.out.println(answer);
        return answer;
    }

    public void DFS(int count,int[][] dungeons, int k,int j){

        System.out.println("DFS("+count+","+k+")");
        answer = Math.max(answer, count);

        for (int i=0; i< dungeons.length; i++){
            int minPirodo = dungeons[i][0];
            int finPirodo = dungeons[i][1];

            if(!visited[i] && minPirodo<=k){
                visited[i]=true;
                DFS( count+1, dungeons, k-finPirodo,i);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        피로도 main = new 피로도();
        main.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        //30 10 80 20 50 40
    }
}
