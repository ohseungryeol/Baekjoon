package Greedy;

import java.util.Scanner;

public class boj20365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String tmp = sc.next();
        char[] color= tmp.toCharArray();
        boolean rFlag = false;
        boolean bFlag = false;
        int rCnt =0;
        int bCnt =0;
        for(int i=0; i<color.length; i++){
            if(color[i]=='B'){
                bFlag = true;
                if(rFlag==true){
                    rCnt++;
                    rFlag=false;
                }
                if(i==color.length-1) bCnt++;
            } else {
                rFlag = true;
                if(bFlag==true){
                    bCnt++;
                    bFlag=false;
                }
                if(i==color.length-1) rCnt++;
            }
        }

        if(bCnt>=rCnt){
            System.out.println(rCnt+1);
        } else {
            System.out.println(bCnt+1);
        }
    }
}
