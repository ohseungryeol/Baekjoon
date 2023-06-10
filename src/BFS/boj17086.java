package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17086 {
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    static int N,M;
    static int[][] map;
    static int answer =0;
    static boolean[][] visited;

    static class Point{
        int x,y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(map[i][j]==0){
                    answer = Math.max(answer,BFS(i,j));
                }
            }
        }

        System.out.println(answer);
    }

    public static int BFS(int x, int y){
        visited = new boolean[N][M];
        visited[x][y]=true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 0));

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for (int i=0; i<8; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                int safeDistance = tmp.cnt+1;
                if(nx>=0 && nx<N &&ny>=0 && ny<M  &&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    queue.offer(new Point(nx,ny,safeDistance));
                } else{
                    continue;
                }

                if(map[nx][ny]==1){
                    return safeDistance;
                }

            }
        }

        return 0;
    }
}
