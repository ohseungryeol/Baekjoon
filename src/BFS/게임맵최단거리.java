package BFS;

import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static class Point{
        int x,y;
        public Point(int x , int y){
            this.x =x;
            this.y =y;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] check;
    static int[][] dis;
    static Queue<Point> queue;
    public int solution(int[][] maps) {
        //0이 벽 //1이 빈칸
        int answer = 0;
        queue = new LinkedList<>();
        BFS(0,0,maps);
        check = new int[maps.length][maps[0].length];
        check[0][0]=1;
        answer = dis[4][4];
        return answer;
    }

    public static void BFS(int x, int y, int[][] maps){
        int row =maps.length;
        int col =maps[0].length;
        queue.offer(new Point(x,y));
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for (int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<row && ny>=0 && ny<col && maps[nx][ny]==1 && check[nx][ny]==0){
                    check[nx][ny]=check[tmp.x][tmp.y]+1;
                    queue.offer(new Point(nx,ny));

                }
            }

        }
    }
}