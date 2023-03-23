import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class boj2533 {
    static ArrayList<ArrayList<Integer>> tree;
    static int[][] dp;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        check = new int[N + 1];
        dp = new int[N + 1][2];
        for (int i=0; i<=N; i++){
            tree.add(new ArrayList<Integer>());
        }

        for (int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        DFS(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void DFS(int n){
        dp[n][0]=0;
        dp[n][1]=1;
        check[n]=1;
        for (int friend: tree.get(n)){
            if(check[friend]==0){
                DFS(friend);
                dp[n][0]+=dp[friend][1];
                dp[n][1]+= Math.min(dp[friend][0],dp[friend][1]);
            }
        }
    }
}
