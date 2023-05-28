package Simulation;

import java.util.Scanner;

public class boj2140 {
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
    static int answer =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] board = new char[n][n];

        for (int i=0; i<n; i++){
            String s = sc.next();
            for (int j=0; j<n; j++){
                board[i][j] = s.charAt(j);
            }
        }

        for (int x=0; x<n; x++){
            for (int y=0; y<n; y++){
                if(board[x][y]=='0'){
                    for (int k=0; k<8; k++){
                        int nx = x+dx[k];
                        int ny = y+dy[k];

                        if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]=='#'){
                            board[nx][ny]='-';

                        }
                    }
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(board[i][j]!='#' && board[i][j]!='-' && board[i][j]!='0'){
                    int cnt = Integer.parseInt(String.valueOf(board[i][j]));
                    for (int k=0; k<8; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]=='#'){
                            cnt--;
                        }
                    }
                    if(cnt==0) answer++;
                }
            }
        }


        System.out.println(answer);

    }
}
