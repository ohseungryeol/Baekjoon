package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17836 { //다시풀자
    static int N, M, T;
    static int[][] map;
    static int[][] dis;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;
        boolean isgram;

        public Point(int x, int y,boolean isgram) {
            this.x = x;
            this.y = y;
            this.isgram = isgram;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken()); //제한시간

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1]; // 0은 그람 x 1은 그람 o
        dis = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[1][1]==2){
            queue.offer(new Point(1, 1,true));
        } else{
            queue.offer(new Point(1, 1,false));
        }

        visited[1][1] = true;
        BFS();

        if(min==Integer.MAX_VALUE){
            System.out.println("Fail");
        } else{
            System.out.println(min);
        }
    }

    public static void BFS() {

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            if(tmp.x == N && tmp.y == M){
                if(dis[N][M]<=T) min = Math.min(min, dis[N][M]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx>0 && nx<=N && ny>0 && ny<=M && tmp.isgram==false && !visited[nx][ny]){ //그람이 없고 방문하지 않았을때
                    if (map[nx][ny]==0){
                        dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                        visited[nx][ny]=true;
                        queue.offer(new Point(nx,ny,false));
                    } else if (map[nx][ny]==2){
                        dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                        visited[nx][ny]=true;
                        queue.offer(new Point(nx,ny,true));
                    }

                }  else if(nx>0 && nx<=N && ny>0 && ny<=M && tmp.isgram==true && !visited[nx][ny]){ //그람이 있고 방문하지 않았을 때
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                    visited[nx][ny]=true;
                    queue.offer(new Point(nx,ny,true));
                }

            }

        }
    }
}



