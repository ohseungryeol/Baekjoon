package Simulation;

import java.util.Scanner;

public class boj20164 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        get_oddNum(n,count);
        System.out.println(min+" "+max);

    }

    public static void get_oddNum(int n, int count ){
        String tmp = String.valueOf(n);
        count+=calcOdd(n);
        if(tmp.length()==1){
            max = Math.max(max, count);
            min = Math.min(min, count);

            return;
        }

        if(tmp.length()==2){
            int num1 = Integer.parseInt(String.valueOf(tmp.charAt(0)));
            int num2 = Integer.parseInt(String.valueOf(tmp.charAt(1)));

            n = num1+num2;
            get_oddNum(n,count);

        } else if (tmp.length()>=3){

            for (int i=1; i<tmp.length()-1; i++){
                for (int j=i+1; j<tmp.length(); j++){

                    int num1 = Integer.parseInt(tmp.substring(0, i));
                    int num2 = Integer.parseInt(tmp.substring(i, j));
                    int num3 = Integer.parseInt(tmp.substring(j));

                    n= num1+num2+num3;
                    get_oddNum(n,count);
                }
            }
        }
    }

    public static int calcOdd(int n){
        String tmp = String.valueOf(n);
        int oddcount=0;
        for (int i=0; i<tmp.length(); i++){
            int num = Integer.parseInt(String.valueOf(tmp.charAt(i)));
            if (num%2 ==1) oddcount++;
        }

        return oddcount;
    }
}
