package Simulation;

import java.util.Scanner;

public class boj15886 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //int[] arr = new int[N];
        String str = sc.next();

        str = str.replaceAll("EW","O");

        int answer =0;

        for (int i=0; i<str.length(); i++){
            if(str.charAt(i)=='O') answer++;
        }

        System.out.println(answer);

    }
}
