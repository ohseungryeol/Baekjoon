import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1010 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(Combi(M,N));// mCn을 구한다.
        }
    }

    public static int Combi(int m, int n){
        if(dp[m][n]>0) return dp[m][n];
        if (n==0 || n==m){
            return 1;
        } else {
            return dp[m][n] = Combi(m-1,n-1)+Combi(m-1,n);
        }
    }
}
