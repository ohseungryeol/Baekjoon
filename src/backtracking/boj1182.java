package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182 {
    static int[] check;
    static int[] arr;
    static int N,S;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0);
        if(S==0){// count 합이 0인 경우 공집합도 포함되므로 그 수를 하나 빼주고 출력
            System.out.println(answer-1);
        }else {
            System.out.println(answer);
        }
    }

    public static void DFS(int L, int sum){
       if(L==N){
           if(sum==S){
               answer++;

           }
           return;
       }

        DFS(L + 1, sum+arr[L]);
        DFS(L + 1, sum);
    }
}
