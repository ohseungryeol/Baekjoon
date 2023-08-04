package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13459 {
    static class Point{
        int x,y;
        char color;

        public Point(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    static char[][] map;
    static int R,C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Point> Rqueue = new LinkedList<>();
    static Queue<Point> Bqueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i=0; i<R; i++){
            String tmp = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='R'){
                    Rqueue.offer(new Point(i,j,'R'));
                } else if (map[i][j]=='B'){
                    Bqueue.offer(new Point(i,j,'B'));
                }
            }
        }
    }

    public static int BFS(){
        return 0;
    }
}
