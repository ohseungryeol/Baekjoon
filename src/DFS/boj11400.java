package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11400 {
    static boolean[] visited;
    static int E,V;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); //1~V까지의 정점
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];
        for (int i=0; i<=V; i++){
            arr.add(new ArrayList<Integer>());
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        DFS(1);
    }

    public static void DFS(int v){
        visited[v]=true;
        int cnt =0;
        for (int nv: arr.get(v)){
            if(!visited[nv]) {
                DFS(nv);
            }
          //  System.out.println(Arrays.toString(players));
        }
    }
}
