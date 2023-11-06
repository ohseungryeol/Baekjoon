
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj1664 {
    static int[] check;
    static int[] primeNum;
    static ArrayList<Integer> Prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        check = new int[N + 1];
        Prime = new ArrayList<>();
        findPrime(N);
        System.out.println(PrimeSum(N));
    }

    public static void findPrime(int N) {

        for (int i = 2; i <= N; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                Prime.add(i);

                for (int j = i; j <= N; j = j + i) {
                    check[j] = 1;
                }

            }
        }
    }

    public static int PrimeSum(int N) {
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if (sum >= N) {
                sum -= Prime.get(start++);

            } else if (end==Prime.size()){
                break;
            } else{
                sum += Prime.get(end++);
            }
            if (sum == N) count++;

        }
        return count;
    }
}
