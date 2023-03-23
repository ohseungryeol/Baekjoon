package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16918 {
    static int R,C;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static char[][] map;
    static Queue<Point> queue = new LinkedList<>();
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken()); //초

        map = new char[R][C];

        for (int i=0; i<R; i++){
            String tmp = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j]=tmp.charAt(j);
            }
        }

        for (int i=2; i<=N; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (map[j][k] == 'O') {
                            queue.offer(new Point(j, k));
                        }
                    }
                }

                for (int m = 0; m < R; m++) {
                    Arrays.fill(map[m], 'O');
                }
                BFS();
            }
        }

        if (N % 2 == 0) {
            for (int i=0; i<R; i++) {
                Arrays.fill(map[i], 'O');
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void BFS(){
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for (int i=0; i<4; i++){
                int nx =tmp.x+dx[i];
                int ny =tmp.y+dy[i];
                map[tmp.x][tmp.y]='.';
                if(nx>=0 && nx<R && ny>=0 && ny<C){
                    map[nx][ny]='.';
                }
            }
        }


    }
}
