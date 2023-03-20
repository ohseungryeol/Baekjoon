import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = board[i][j] + dp[i][j - 1];
            }
        }

        /*for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        int K = Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(arrSum(x1,y1,x2,y2,dp,board));
        }


    }

    public static int arrSum(int x1, int y1, int x2, int y2, int[][] dp, int[][] board) {
        int sum=0;

        if (y1==1){
            for(int i=x1; i<=x2; i++){
                sum+=dp[i][y2];
            }
        } else{
            for (int i=x1; i<=x2; i++){
                sum += dp[i][y2]-dp[i][y1 - 1];
            }
        }

        return sum;
    }
}
