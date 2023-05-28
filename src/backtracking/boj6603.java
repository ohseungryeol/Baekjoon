package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj6603 {
    static int[] answer;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;
            int[] arr = new int[k];
            int[] check = new int[k];
            answer = new int[6];
            for (int i=0; i<k; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            DFS(0, 0,arr,check);
            System.out.println();
        }
    }

    public static void DFS(int start, int L, int[] arr, int[] check){
        if(L==6) {
            for (int i=0; i<6; i++){
                System.out.print(answer[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i=start; i<k; i++){
            if(check[i]==0) {
                check[i]=1;
                answer[L] = arr[i];
                DFS(i+1,L + 1, arr,check);
                check[i]=0;
            }

        }
    }
}
