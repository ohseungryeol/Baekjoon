package 멋쟁이사자처럼;

import java.util.Scanner;

public class 문제3 { // 하-3 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next(); // 입력값
        int sum=0; //자릿수 제곱의 합을 저장하는 변수

        for (char x:N.toCharArray()){ //String을 char 배열로 변환
            int num =  Character.getNumericValue(x); // 추출된 char형을 int로 변환
            sum+=num*num;
        }

        System.out.println(sum);
    }
}
