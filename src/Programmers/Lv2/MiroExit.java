package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class MiroExit {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int r,c;
    static boolean[][] visited;
    static boolean flag =false;
    static char[][] miro;
    static int[][] dis;
    static int arriveL=Integer.MAX_VALUE;;
    static int arriveE=Integer.MAX_VALUE;;
    static int answer = Integer.MAX_VALUE;
    static Queue<Point> queue = new LinkedList<>();

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        MiroExit miroExit = new MiroExit();
        String[] maps = {"OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        miroExit.solution(maps);
    }

    public int solution(String[] maps) {
        r=maps.length;
        c=maps[0].length();
        miro = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        dis = new int[maps.length][maps[0].length()];

        for (int i=0; i<maps.length; i++){
            String tmp = maps[i];
            for (int j=0; j<maps[i].length(); j++){
                miro[i][j]=tmp.charAt(j);
                if(miro[i][j]=='S') queue.offer(new Point(i,j));
            }
        }
        BFS();
        String[] word = {""};
        System.out.println(answer);
        if(answer==Integer.MAX_VALUE || flag==false){
            return -1;
        } else{
            return answer;
        }

    }

    public static void BFS(){
        while(!queue.isEmpty()){
            Point tmp = queue.poll();

            for (int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>=0 && nx<r && ny>=0 && ny<c && !visited[nx][ny]){
                    if(miro[nx][ny]=='X') continue;

                    visited[nx][ny]=true;
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                    queue.offer(new Point(nx,ny));
                    if(miro[nx][ny]=='L') {
                        arriveL = Math.min(arriveL,dis[nx][ny]);
                        flag = true;
                    }
                    if(miro[nx][ny]=='E'){
                        if(flag==false) continue;
                        else answer = Math.min(answer,dis[nx][ny]);
                    }
                }
            }
        }
    }

}
