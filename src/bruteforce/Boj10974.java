package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Boj10974 {
    static int[] arr;
    static boolean[] check;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();

        arr = new int[n+1];
        check = new boolean[n+1];
        DFS(1);
    }

    public static void DFS(int L){
        if(L==n+1){
            for(int i=1; i<=n; i++) System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for (int i=1; i<=n; i++){
            if(!check[i]){
                check[i]=true;
                arr[L]=i;
                DFS(L+1);
                check[i]=false;
            }
        }
    }
}
