import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //로프 갯수
        int maxSum =-1;
        Integer[] maxWeight = new Integer[n];

        for (int i=0; i<n; i++) maxWeight[i]=sc.nextInt();


        Arrays.sort(maxWeight);

        for (int i=0; i<n; i++){
            maxSum = Math.max(maxSum,maxWeight[i]*(n-i));
        }

        System.out.println(maxSum);


    }
}
