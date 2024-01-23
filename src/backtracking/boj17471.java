package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj17471 {
    static ArrayList<Integer>[] graphs ;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graphs = new ArrayList[N + 1];
        nums = new int[N + 1];
        visited = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for (int j=1; j<=s; j++){
                graphs[i] = new ArrayList<>();
                graphs[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=1; i<=N; i++){
            boolean[] check = new boolean[graphs[i].size()];
            //i가 구역이고 이거에 대한 조합
        }
    }

    public static void Combi(int i, int L,boolean[] check){

        for (int s=0; s<graphs[i].size(); s++){
            if(!check[s]){
                check[s]=true;
                Combi(i,L+1,check);
                check[s]=false;
            }
        }
    }
}
