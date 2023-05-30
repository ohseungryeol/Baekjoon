package String;

import jdk.jshell.Snippet;

import java.util.Scanner;

public class boj5525 {
    public static void main(String[] args) {
        /*
        P(N) = N+1개의 I와 N개의 O가 번갈아가면서 나옴
        N= 1이면 IOI가 몇개 ?
        N =2이면 IOIOI가 몇 개?
        2N+1개 ioi
        * */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // IOI -> 2N+1
        int M = sc.nextInt(); // 입력 길이
        String str = sc.next();
        String ioi = "I";
        int len = 2*N+1;
        for (int i=1; i<len; i++){
            if(i%2==1) ioi+= "O";
            else ioi+="I";
        }

        System.out.println(ioi);
        int cnt =0;
        for (int i=0; i<=str.length()-(2*N+1); i++){
            if(str.charAt(i)=='I' && str.substring(i,i+len).equals(ioi)){
                cnt++;
                //System.out.println(i);
                i+=1;
            }

        }

        System.out.println(cnt);
    }
}
