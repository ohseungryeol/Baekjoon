import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11725 {
    static int N;
    static int[] check;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        check = new int[N + 1];
        parent = new int[N + 1];
        tree = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=N; i++){
            tree.add(new ArrayList<Integer>());
        }
        for (int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        DFS(1);

        for (int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int n){
        check[n]=1;

        for (int child: tree.get(n)){
            if(check[child]==0) {
                parent[child]=n;
                DFS(child);
            }
        }
    }
}
