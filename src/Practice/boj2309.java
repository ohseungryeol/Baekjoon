package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum =0;
        for (int i=0; i<9; i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }


        for (int i=0; i<8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int twosum = arr[i] + arr[j];
                if ((sum - twosum) == 100) {
                   arr[i]=0;
                   arr[j]=0;
                   break;
                }
            }
        }


        Arrays.sort(arr);

        for (int i=2; i<9; i++){
            System.out.println(arr[i]);
        }



    }
}
