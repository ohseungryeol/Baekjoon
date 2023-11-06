package SamsungSW.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 보급로 {
    static class Point implements Comparable<Point>{
        int x,y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time-o.time;
        }
    }
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test<=T; test++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            answer = Integer.MAX_VALUE;
            for (int i=0; i<N; i++){
                String tmp = br.readLine();
                for (int j=0; j<N; j++){
                    map[i][j]=Integer.parseInt(String.valueOf(tmp.charAt(j)));
                }
            }

            BFS();
            System.out.printf("#%d %d\n",test,answer);
        }
    }

    public static void BFS(){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(0,0,0));
        visited[0][0]=true;

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;
            int time = tmp.time;

            for (int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    if(nx==N-1 && ny==N-1){
                        answer = time+map[nx][ny];
                        return;
                    }
                    queue.offer(new Point(nx,ny,time+map[nx][ny]));
                }
            }
        }
    }
}
