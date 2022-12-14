import java.util.Scanner;

public class boj15652 {

    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M+1];

        dfs(1, 1);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {

        if (depth == M+1) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }

    }

}