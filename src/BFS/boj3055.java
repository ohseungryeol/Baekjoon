package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3055 {
    static int R,C;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static boolean flag = false;
    static int answer =Integer.MAX_VALUE;
    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        /*
         * 물 X 돌 . 빈칸  S 출발 D 도착
         * 물과 인접한 빈칸은 물로 변환
         * 물 먼저 번식 -> 그 후 이동
         *
         * */

        for (int i=0; i<R; i++){
            String tmp = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j]=tmp.charAt(j);
                if(map[i][j]=='*'){
                    water.offer(new int[]{i,j});
                }
                if(map[i][j]=='S'){
                    queue.offer(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }

        bfsWater();

        if(answer==Integer.MAX_VALUE){
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }

    }

    public static void BFS(){
        int len = queue.size();
        for (int j=0; j<len; j++) {
            int[] tmp = queue.poll();
            int x =tmp[0];
            int y =tmp[1];
            int time = tmp[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //고슴도치는 물이나 돌로 이동불가
                if (!isRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '.' || map[nx][ny] == 'D') {

                    if (map[nx][ny] == 'D') {
                        visited[nx][ny] = true;
                        answer = Math.min(answer, time + 1);
                    } else {
                        map[nx][ny]='S';
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, time + 1});

                    }
                }
            }
        }

    }

    public static void bfsWater(){
        while(!water.isEmpty()){
            int len = water.size();
            for (int j=0; j<len; j++) {

                int[] wt = water.poll();
                int x = wt[0];
                int y = wt[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 물은 map범위 안에있고 인접한 빈칸이 돌이 아니면 퍼짐
                    if (!isRange(nx, ny)) continue;
                    if (map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                    if (map[nx][ny] == '.' || map[nx][ny]=='S' ) {
                        map[nx][ny] = '*';
                        water.offer(new int[]{nx, ny});

                    }
                }
            }
            // 물이 퍼지도 난 다음 고슴도치 이동
            BFS();

        }
    }

    public static boolean isRange(int nx, int ny){
        if(nx>=0 && nx<R && ny>=0 && ny<C){
            return true;
        }

        return false;
    }
}
