package Greedy;

import java.util.Scanner;

public class boj1789 {
    public static void main(String[] args) {
        //최대한 많은 숫자로 S를 만들기
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();

        int i=1;
        int sum=0;
        while(true){
            sum+=i++;
            if(sum>S){
                System.out.println(i);
                break;
            }
        }
    }
}
