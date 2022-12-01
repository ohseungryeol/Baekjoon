import java.util.Scanner;

public class boj15650 {
    static int N,M;
    static int[] check;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        arr = new int[M+1];

        DFS(1,1);
    }

    public static void DFS(int at, int depth){

        if (depth ==M+1) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=at; i<=N; i++){
                arr[depth]=i;
                DFS(i+1,depth+1);
            }
        }

}
