import java.util.Scanner;

public class boj2748 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[91];
        dp[0]=0;
        dp[1]=1;

    }

    public static int fibo(int n){
        if(n==0){
            return 0;
        } else if (n==1){
            return 1;
        } else{
            return dp[n] = dp[n - 1] + dp[n - 2];
        }
    }
}
