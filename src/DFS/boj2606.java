package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2606 {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] check;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //컴퓨터 수
        int E = Integer.parseInt(br.readLine()); //간선의 수
        check = new int[N + 1];
        arr = new ArrayList<>();
        for (int i=0; i<=N; i++){
            arr.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.get(s).add(e);
            arr.get(e).add(s);
        }
        check[1]=1;
        DFS(1);
        System.out.println(count);
    }

    public static void DFS(int n){

        if (arr.get(n).size()==0) return;


        for (int c : arr.get(n)){
            if(check[c]==0){
                check[c]=1;
                count++;
                DFS(c);
            }
        }
    }
}
