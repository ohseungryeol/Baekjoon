package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14503 {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] check;
    static int[][] room;
    static int see;
    static int N,M;
    static Queue<Point> queue = new LinkedList<>();
    static int answer=0;

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
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        check = new int[N][M];
        st = new StringTokenizer(br.readLine());
        //로봇이 있는 좌표
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        see = Integer.parseInt(st.nextToken()); //로봇이 보는 방향
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. if(room[x][y]) ==0 answer++ 현재 칸이 빈칸이면
        // 2.
        BFS(x,y);
        System.out.println(answer);
    }

    public static void BFS(int x, int y){
        queue.offer(new Point(x, y));
        while(!queue.isEmpty()){
            boolean flag = false;
            Point tmp= queue.poll();

            if(room[tmp.x][tmp.y]==0){
                answer++;
                room[tmp.x][tmp.y]=2;
            }
            for (int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N && room[nx][ny]==0){
                    flag =true; //청소 안된 칸이 있음
                    if(see==0){
                        see=3;
                        if(room[tmp.x][tmp.y-1]!=1){
                            queue.offer(new Point(tmp.x+1,tmp.y));
                        }
                    } else if (see==1){
                        see=0;
                        if(room[tmp.x-1][tmp.y]==0){
                            queue.offer(new Point(tmp.x-1,tmp.y));
                        }
                    } else if (see==2){
                        see=1;
                        if(room[tmp.x][tmp.y+1]==0){
                            queue.offer(new Point(tmp.x,tmp.y+1));
                        }
                    } else if (see==3){
                        see=2;
                        if(room[tmp.x+1][tmp.y]==0){
                            queue.offer(new Point(tmp.x+1,tmp.y));
                        }
                    }

                }
                //if(nx>=0 && nx<M && ny>=0 &&ny<N && room[nx][ny]==0) flag = true; // 빈칸이 없 것
            }
            if(flag==false){ //빈칸이 없는 경우
                if(see==0){

                    if(room[tmp.x+1][tmp.y]!=1){
                        queue.offer(new Point(tmp.x+1,tmp.y));
                    } else{
                        return;
                    }
                } else if (see==1){

                    if(room[tmp.x][tmp.y-1]!=1){
                        queue.offer(new Point(tmp.x,tmp.y-1));
                    } else{
                        return;
                    }
                } else if (see==2){

                    if(room[tmp.x-1][tmp.y]!=1){
                        queue.offer(new Point(tmp.x-1,tmp.y));
                    } else{
                        return;
                    }
                } else if (see==3){

                    if(room[tmp.x][tmp.y+1]!=1){
                        queue.offer(new Point(tmp.x,tmp.y+1));
                    } else{
                        return;
                    }
                }
            }

        }
    }
}
