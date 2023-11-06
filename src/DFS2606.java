import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS2606 {

    static int[][] arr;
    static int[] check;
    static int cnt=0;
    public static void DFS(int start){

        if(check[start]==1) return; //이미 방문했으면 재귀종료
        check[start] = 1;
        cnt++;
        for (int i=1; i<arr.length; i++){
            if(check[i]==0 && arr[start][i]==1){
                DFS(i);
            }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int edge = sc.nextInt();
        arr = new int[n + 1][n + 1];
        check = new int[n + 1];
        for (int i=0; i<edge; i++){
            int F = sc.nextInt();
            int L = sc.nextInt();
            arr[F][L] = 1;
            arr[L][F] = 1;
        }
        DFS(1);
        System.out.println(cnt-1); //1번정점은 제외해야하므로 -1
    }
}
