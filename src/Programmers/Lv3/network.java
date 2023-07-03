package Programmers.Lv3;

import java.util.ArrayList;
import java.util.Scanner;

public class network {
    static ArrayList<ArrayList<Integer>> tree;
    static int[][] computers;
    static int[] check;
    static int answer =1;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        computers = new int[N][N];
        check = new int[N];
        for (int i=0;i<N; i++){
            for (int j=0; j<N; j++){
                computers[i][j] = sc.nextInt();
            }
        }
        //asdasdasdasdasdasd
        for (int i=0; i<N; i++){
            if(check[i]==0){
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int x){
        check[x]=1;
        for (int i=0; i<N; i++){
            if( i!= x && check[i]==0 && computers[x][i]==1){
                DFS(i);
            }
        }
    }
}
