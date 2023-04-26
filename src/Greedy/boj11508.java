package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class boj11508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int answer =0;

        if(N<3){
            for (int i=0; i<N; i++){
                answer+=arr[i];
            }
        } else {
            for(int i=0; i<N; i+=3){
                if(i+2==N){
                    answer+=arr[i]+arr[i+1];
                    break;
                } else if (i+1==N){
                    answer+=arr[i];
                    break;
                }
                answer+=arr[i]+arr[i+1];
            }
        }

        System.out.println(answer);

    }
}
