package SamsungSW.d3;

import java.util.Scanner;

public class 최빈수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();

        for (int i=1; i<=T; i++){
            int testNum = sc.nextInt();
            int[] arr = new int[101];
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for (int j=0; j<1000; j++){
                int num = sc.nextInt();
                arr[num]++;
            }

            for (int k=0; k<=100; k++){
                if(max<=arr[k] && maxIdx<k){
                    max = arr[k];
                    maxIdx = k;
                }
            }

            System.out.printf("#%d %d\n",testNum,maxIdx);

        }
    }
}
