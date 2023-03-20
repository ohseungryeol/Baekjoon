package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] money = new Integer[N];
        for (int i=0; i<N; i++){
            money[i]=sc.nextInt();
        }
        Arrays.sort(money, Collections.reverseOrder());
        int index=0;
        int count=0;

        for (int i=0; i<N; i++){
            if(money[i]>K){
                continue;
            } else{
                count += K/money[i];
                K = K%money[i];
            }
        }
        System.out.println(count);
    }
}
