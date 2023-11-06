package SamsungSW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SUM {
    static int answer;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =10;
        arr = new int[100][100];
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer=0;
            int t = Integer.parseInt(br.readLine());
            for (int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<100; i++){
                maxRow(i);
                maxCol(i);
            }
            maxDiagonal();
            System.out.printf("#%d %d\n",test_case,answer);
        }
    }

    public static void maxRow(int row){
        int sum=0;
        for (int i=0; i<100; i++){
            sum += arr[row][i];
        }
        answer = Math.max(answer, sum);
    }
    public static void maxCol(int col){
        int sum=0;
        for (int i=0; i<100; i++){
            sum +=arr[i][col];
        }
        answer = Math.max(answer, sum);
    }
    public static void maxDiagonal(){
        int leftSum=0;
        int rightSum=0;
        for (int i=0; i<100; i++){
            leftSum+=arr[i][i];
        }
        int col =99;
        for (int i=0; i<100; i++){
            rightSum += arr[i][col--];
        }

        answer = Math.max(answer, leftSum);
        answer = Math.max(answer, rightSum);
    }
}
