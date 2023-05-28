package backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj15664 {
    static int N,M;
    static int[] check;
    static int[] arr;
    static int[] answer;
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
        DFS(0,0);
    }
    public static void DFS(int start , int L){
        if(L==M){
            for (int i=0; i<M; i++){
                System.out.print(answer[i]+" ");
            }
            System.out.println();
            return;
        }
        int before =0;
        for (int i=start; i<N; i++){
            if(check[i]==0 && before!=arr[i]) {

                check[i]=1;
                answer[L] = arr[i];
                before = arr[i];
                DFS(i+1,L + 1);
                check[i]=0;
            }
        }
    }
}
