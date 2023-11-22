package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182 {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] check;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        DFS(0, 0);
        System.out.println(answer);
    }

    //합이 S가 되는 부분수열들을 찾는다.
    public static void DFS(int L, int sum){
        if(L==N){
            if(sum==S){
                answer++;

            }
            return;
        }

        DFS(L+1,sum+arr[L]);
        DFS(L+1,sum);

    }
}
