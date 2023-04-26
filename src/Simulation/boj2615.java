package Simulation;

import java.util.Scanner;

public class boj2615 {
    static int[][] check;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[20][20];
        check = new int[20][20];
        //검정은 1 흰색은 2 빈공간은 0
        for (int i=1; i<20; i++){
            for (int j=1; j<20; j++){
                board[i][j]=sc.nextInt();
            }
        }
    }

    public static void rightCol(int i, int j){
        int col = j+4;

        for (int c=j; c<=col; j++){
            if(board[i][j]==1){

            }
        }
    }


}
