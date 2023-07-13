package DivideConquer;

import java.util.Scanner;
import java.util.Stack;

public class boj1992 {
    static int n;
    static int[][] board;
    static Stack<Character> stack = new Stack<>();
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i=0; i<n; i++){
            String line = sc.next();
            for (int j=0; j<n; j++){
                board[i][j]=Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        Divide(0,0,n);
        System.out.println(answer.toString());

    }
        /*
        * 왼상, 오상, 왼하 오하
        *
        * */
    public static void Divide(int r, int c, int size){ //시작행, 시작열, size
        if(isSameNum(r,c,size)){ //0,0,8
            if(board[r][c]==0){
                answer.append("0");
            } else {
                answer.append("1");
            }
            return;
        }
        if(size==1){
            return;
        }

        answer.append("(");
        //쪼개질게 남았을 때
        size = size/2;
        Divide(r,c,size); //왼상
        Divide(r,c+size,size); //오 상
        Divide(r+size,c,size); //왼 하
        Divide(r+size,c+size,size);  //오 하
        answer.append(")");
    }

    public static boolean isSameNum(int r, int c,int len){ //0,0,4

        int num = board[r][c];

        for (int i=r; i<r+len; i++){
            for (int j=c; j<c+len; j++){
                if(board[i][j]!=num) return false;
            }
        }
        return true;
    }
}
