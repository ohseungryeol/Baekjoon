package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //보유 현금
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] chart = new int[14];

        for (int i=0; i<14; i++){
            chart[i] = Integer.parseInt(st.nextToken());
        }

        if(BNP(chart,N)>Timing(chart,N)){
            System.out.println("BNP");
        } else if (BNP(chart,N)==Timing(chart,N)){
            System.out.println("SAMESAME");
        } else{
            System.out.println("TIMING");
        }
    }

    public static int BNP(int[] chart, int N){
        int money = N;
        int count=0;
        int maxMoney=0;
        for (int i=0; i<chart.length; i++){
            if(chart[i]<=money && money>0){
                count = money / chart[i];
                money = money % chart[i];
            }
        }

        return money+(chart[13]*count);
    }

    public static int Timing(int[] chart, int N){
        int money =N;
        int count=0;
        int maxMoney=0;
        boolean flag =false;
        for (int i=0; i<chart.length-3; i++){
            //매수법
            if(chart[i]>chart[i+1] && chart[i+1]>chart[i+2] && i+3<chart.length && money>chart[i+3]){
                count += money/chart[i+3];
                money = money % chart[i+3];
                flag = true;
            }

            // 매도법
            if(chart[i]<chart[i+1] && chart[i+1]<chart[i+2] && i+3<chart.length && flag==true){
                maxMoney += money+(count*chart[i+3]);
                flag = false;
            }
        }
        maxMoney = Math.max(maxMoney,money+(count*chart[13]));

        return maxMoney;
    }
}
