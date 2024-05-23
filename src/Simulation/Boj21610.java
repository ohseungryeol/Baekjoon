package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj21610 {
    static class Cloud{
        int x,y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] diagX = {-1, -1, 1, 1};
    static int[] diagY = {-1, 1, -1, 1};
    static int d,s;
    static int N,M;
    static int[][] map;
    static Queue<Cloud> queue = new LinkedList<>();
    static boolean[][] visited;
    static int answer=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 시뮬 횟수
        map = new int[N][N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (N-1, 0), (N-1, 1), (N-2, 0), (N-1, 1)
        // 구름 초기화

        queue.offer(new Cloud(N - 2, 0));
        queue.offer(new Cloud(N - 2, 1));
        queue.offer(new Cloud(N - 1, 0));
        queue.offer(new Cloud(N - 1, 1));
        visited = new boolean[N][N];
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()); //방향
            s = Integer.parseInt(st.nextToken()); // 이동횟수

            // 구름이동
            cloud_move(d, s);
            new_cloud();
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                answer+=map[i][j];
            }
        }

        System.out.println(answer);
    }

    public static void cloud_move(int d, int s){

        while(!queue.isEmpty()){
            Cloud cloud = queue.poll();

            int nx = (N + cloud.x + dx[d] * (s % N)) % N;
            int ny = (N + cloud.y + dy[d] * (s % N)) % N;
            // 1씩 증가
            map[nx][ny]+=1;

            int dCount=0;

            for (int i=0; i<4; i++){
                int diag_x = nx+diagX[i];
                int diag_y = ny+diagY[i];

                if(isRange(diag_x,diag_y) && map[diag_x][diag_y]>0) dCount++;
            }
            map[nx][ny]+=dCount;
            visited[nx][ny]=true;
        }
    }

    public static void new_cloud(){
        // 큐 초기화
        queue.clear();
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j]>=2){
                    queue.offer(new Cloud(i, j));
                    map[i][j]-=2;
                    if(map[i][j] < 0) {
                        map[i][j] = 0;
                    }
                }
            }
        }

        visited = new boolean[N][N];
    }


    public static boolean isRange(int nx, int ny){
        return (nx>=0 && nx<N && ny>=0 && ny<N);
    }
}
