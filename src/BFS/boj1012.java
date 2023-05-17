package BFS;

import java.util.Scanner;

public class boj1012 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            int c = sc.nextInt(); //열
            int r = sc.nextInt(); //가로
            int cabbageNum = sc.nextInt();

            int[][] farm = new int[r][c];

            for (int j=0; j<cabbageNum; j++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                farm[x][y] = 1;
            }
            int answer =0;
            for (int m=0; m<r; m++){
                for (int k=0; k<c; k++){
                    if(farm[m][k]==1){
                        farm[m][k]=2;
                      //  System.out.println(m+","+k);
                        DFS(m,k,r,c,farm);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void DFS(int x, int y, int r, int c, int[][] farm){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<r && ny>=0 && ny<c && farm[nx][ny]==1){
                farm[nx][ny]=2;
                DFS(nx,ny,r,c,farm);
            }
        }
    }
}
