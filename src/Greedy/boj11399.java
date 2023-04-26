package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class boj11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] sumArr = new int[N];
        int sum =0;
        for (int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i=0; i<N; i++){
            sum+=arr[i];
            sumArr[i]=sum;
        }
        int totalSum=0;
        for (int i=0; i<N; i++){
            totalSum+=sumArr[i];
        }

        System.out.println(totalSum);




    }
}
