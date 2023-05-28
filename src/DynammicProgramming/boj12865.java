package DynammicProgramming;

import java.util.Scanner;

public class boj12865 {
    static int N,K;
    static int[] W;
    static int[] V;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //물건갯수
        K = sc.nextInt(); //가방에 최대 담을 수 있는 무게
        W = new int[N];
        V = new int[N];
        dp = new int[101][100001];


        for (int i=0; i<N; i++){
            W[i]=sc.nextInt();
            V[i]=sc.nextInt();
        }

        System.out.println(get_maxValue(0,0));

    }

    public static int get_maxValue(int i, int w){ //물건 번호, 해당 무게
        int n1=0;
        int n2=0;
        if(dp[i][w]>0) return dp[i][w];
        if(i==N) return 0;

        if(w+W[i]<=K) { // 이전까지 무게와 현재 물건의 무게를 더했을 때 가방 최대 한도를 초과하는가?
            n1 = V[i] + get_maxValue(i + 1, w + W[i]); //초과하지 않는다면 현재 물건을 가방에 넣는다. (물건 포함)
        }
        n2 = get_maxValue(i + 1, w); // 가방에 미포함

        return dp[i][w]= Math.max(n1,n2);
    }
}
