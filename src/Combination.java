import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    static int N,M;
    static boolean[] check;
    static int[] arr;
    static int answer=0;
    public static void main(String[] args) {
        //1부터 N까지의 숫자중 M개를 뽑는 경우의 수를 구하시오.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        //for (int i = 0; i < N; i++) arr[i] = i + 1;
        Combi(0, 1);
        System.out.println(answer);

    }

    public static void Combi(int L,int start){
        if(L==M){
            System.out.println(Arrays.toString(arr));
            answer++;
            return;
        }
        for (int i=start; i<=N; i++){
            arr[L]=i;
            Combi(L+1,i+1);
        }
    }
}
