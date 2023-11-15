package SamsungSW.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 가능한시험점수 {
    static int[] arr;
    static boolean[] check;
    static HashSet<Integer> set;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test=1; test<=T; test++){
            N = Integer.parseInt(br.readLine()); //문제 갯수
            arr = new int[N];
            check = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            set = new HashSet<>();
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
           // set.add(0);
            DFS(0,0);
            System.out.printf("#%d %d\n",test,set.size());
        }

    }

    public static void DFS(int L, int sum){
        if(!set.contains(sum)) set.add(sum);
        else return;
        if(L==N) return;

        DFS(L+1,sum+arr[L]);
        DFS(L+1,sum);
    }
}
