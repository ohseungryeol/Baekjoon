package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class boj14503 { //로봇 청소기
    static int answer=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] board = new int[r][c];

        st = new StringTokenizer(br.readLine());
        // 로봇이 있는 좌표와 방향
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<c; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            boolean flag = false; // 빈칸이 없는 경우
            if(board[x][y]==0){
                board[x][y]=2; // 현재 칸이 빈칸이면 청소
                answer++;
            }

            for (int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (nx>=0 && nx<r &&ny>=0 && ny<c && board[nx][ny]==0){ //주변 4곳중 빈칸이 있다면
                    flag = true;
                    if(d==0){
                        d=3;
                    } else {
                        d--;
                    }
                    if(board[x+dx[d]][y+dy[d]]==0){
                        x = x+dx[d];
                        y = y+dy[d];
                    }
                    break;
                }
            }

            if(flag == false){
                if(d==0){
                    if(board[x+1][y]==1){
                        break;
                    } else{
                        x = x+1;
                    }
                } else if (d==1){
                    if(board[x][y-1]==1){
                        break;
                    } else {
                        y=y-1;
                    }
                } else if (d==2){
                    if(board[x-1][y]==1){
                        break;
                    } else {
                        x=x-1;
                    }
                } else if (d==3){
                    if(board[x][y+1]==1){
                        break;
                    } else{
                        y = y+1;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
