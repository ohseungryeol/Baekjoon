package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2468 {
    static int[][] map;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        int maxHeight=0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>maxHeight) maxHeight = map[i][j];
            }
        }
        int answer =0;

        for(int h=0; h<maxHeight; h++) {
            int safeZone = 0;
            boolean[][] check = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]>h && !check[i][j]){
                        DFS(i,j,h,check);
                        safeZone++;

                    }
                }
            }
            answer = Math.max(answer,safeZone);
        }

        System.out.println(answer);


    }

    public static void DFS(int x,int y, int height,boolean[][] check){
        check[x][y] = true;
        for (int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if( isRange(nx,ny,height) && !check[nx][ny]){
                DFS(nx,ny,height,check);
            }
        }
    }

    public static boolean isRange(int nx,int ny,int height){
        if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]>height) return true;
        return false;
    }
}
