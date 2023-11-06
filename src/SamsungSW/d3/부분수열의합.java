package SamsungSW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {
    static int N;
    static int K;
    static int[] arr;
    static int answer;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test = 1; test<=T; test++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //갯수
            K = Integer.parseInt(st.nextToken()); // 합
            arr = new int[N];
            check = new boolean[N];
            answer =0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            DFS(0,0);
            System.out.printf("#%d %d\n",test,answer);
        }
    }

    public static void DFS(int L, int sum){
        if(sum==K){
            answer++;
            return;
        }

        if(L==N || sum>K) return;

        DFS(L+1,sum+arr[L]);
        DFS(L+1,sum);
    }
}
