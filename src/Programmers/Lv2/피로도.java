package Programmers.Lv2;

public class 피로도{
    static int answer=0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(0, k, dungeons, 0);
        System.out.println(answer);
        return answer;
    }

    public static void DFS(int L, int k, int[][] dungeons, int num){
        System.out.printf("DFS(%d %d %d)\n",L,k,num);
        answer = Math.max(answer, num);
        if(L==dungeons.length || k<=0){
            return;
        }

        for (int i=0; i< dungeons.length; i++){
            int[] info = dungeons[i];
            int minPiro = info[0]; //최소 필요도
            int minusPiro = info[1]; //소모 필요도
            if(!visited[i] && k>=minPiro){
                visited[i]=true;
                DFS(L+1,k-minusPiro,dungeons,num+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        피로도 main = new 피로도();
        main.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        /*
        * 유저가 탐험할 수 있는 최대 던전 수
        [최소 피로도, 소모 피로도 ]
        k = 현재피로도
        * */

    }
}