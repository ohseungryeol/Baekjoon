package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int r,c;
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        for (int i=0; i<r; i++){
            String tmp = br.readLine();
            char[] ch = tmp.toCharArray();
            for (int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(String.valueOf(ch[j]));
            }
        }

        BFS(0, 0,map);
        System.out.println(map[r-1][c-1]);
    }

    public static void BFS(int x ,int y, int[][] map){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for (int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny]==1){
                    map[nx][ny]=map[tmp.x][tmp.y]+1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
    }
}
