package DynammicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj13302 {
    static int[][] dp;
    static int N,M;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //여름방학 일수
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        check = new boolean[101];
        for (int i=0; i<M; i++){
            check[Integer.parseInt(st.nextToken())]=true;
        }
        dp = new int[101][41]; //일 당 최소 비용을 저장하는 배열

        for (int i=1; i<=100; i++){
            for (int j=1; j<=40; j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        System.out.println(DFS(0, 0, 0));


    }

    /*
    * 원래 만원
    3일연속: 25000   5일연속: 37000
    쿠폰1장             쿠폰 2장
    쿠폰 3장 = 하루 이용권 1장
    * */
    public static int DFS(int day, int money, int coupon){
        if(day>N) return 0;

        if(dp[day][coupon] != Integer.MAX_VALUE) return dp[day][coupon];
        if(check[day]){
            return dp[day][coupon]=Math.min(dp[day][coupon],money+DFS(day+1,money,coupon));
        }
        if(coupon>=3){
            dp[day][coupon]=Math.min(dp[day][coupon],money+DFS(day+1,money,coupon-3));
        }
        dp[day][coupon] = Math.min(dp[day][coupon],money+DFS(day+1,money+10000,coupon));
        dp[day][coupon] = Math.min(dp[day][coupon],money + DFS(day + 3, money+25000,coupon+1));
        dp[day][coupon] = Math.min(dp[day][coupon],money + DFS(day + 5, money+37000,coupon + 2));


        return dp[day][coupon];
    }
}
