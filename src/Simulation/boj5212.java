package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj5212 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] island = new char[r][c];
        char[][] after = new char[r][c];
        for (int i=0; i<r; i++){
            String str = br.readLine();
            for (int j=0; j<c; j++){
                island[i][j]=str.charAt(j);
                after[i][j]=str.charAt(j);
            }
        }



        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if(island[i][j]=='X'){
                    int cnt=0;
                    for (int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        // 상하좌우가 범위 밖이거나 '.'이면 바다이다. cnt 추가
                        if(nx==-1 || nx==r ||ny==-1 || ny==c || island[nx][ny]=='.'){
                            cnt++;
                        }
                    }
                    //cnt 3이상이면 바다로 바뀜
                    if(cnt>=3){
                        after[i][j]='.';
                    }
                }
            }
        }
        int minC=Integer.MAX_VALUE;
        int maxC=Integer.MIN_VALUE;
        int minR=Integer.MAX_VALUE;
        int maxR=Integer.MIN_VALUE;

        //상하좌우 X에 시작점 체크 -> 직사각형 만들기위해
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if(after[i][j]=='X'){
                    minC = Math.min(minC,j);
                    maxC = Math.max(maxC,j);
                    minR = Math.min(minR,i);
                    maxR= Math.max(maxR,i);
                }
            }
        }

        for (int i=minR; i<=maxR; i++){
            for (int j=minC; j<=maxC; j++){
                System.out.print(after[i][j]);
            }
            System.out.println();
        }

    }
}
