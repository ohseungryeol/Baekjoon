package backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj15665 {
    static int N,M;
    static int[] check;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        check = new int[N];
        answer = new int[M];
        for (int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        // N개의 자연수 중에서 길이가 M인 수열 오름차순
        Arrays.sort(arr);
        DFS(0);
        System.out.print(sb);
    }
    public static void DFS(int L){
        if(L==M){
            for (int i=0; i<M; i++){
                sb.append(answer[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int before =0;
        for (int i=0; i<N; i++){
            if(before!=arr[i]) {
                answer[L] = arr[i];
                before = arr[i];
                DFS(L + 1);
            }
        }
    }
}
