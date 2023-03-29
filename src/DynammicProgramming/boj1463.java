package DynammicProgramming;

import java.util.Scanner;

public class boj1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N + 1];
        dp[1] = 0;

        if(N>=4) {
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= N; i++) {
                if (i % 2 == 0 && i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 2], dp[i / 3]) + 1;
                } else if (i % 2 == 0 && i % 3 != 0) {
                    dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
                } else if (i % 3 == 0 && i % 2 != 0) {
                    dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        } else{
            for (int i=2; i<=N; i++){
                dp[i]=1;
            }
        }

        System.out.println(dp[N]);
    }
}