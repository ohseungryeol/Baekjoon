package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13460 {
    static int R,C;
    static int[] dx = {0,-1, 0, 1, 0}; // 정지,상,좌,하,우
    static int[] dy = {0,0, -1, 0, 1};
    static char[][] board;
    static boolean[][][][] visited;
    static Queue<Ball>queue = new LinkedList<>();
    static int answer=0;
    static class Ball{
       int rx,ry,bx,by,cnt;

        public Ball(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx; // type
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C][R][C];
        int rx=0,ry=0,bx=0,by=0;
        for (int i=0; i<R; i++){
            String tmp = br.readLine();
            for (int j=0; j<C; j++){
                board[i][j] = tmp.charAt(j);
                if(board[i][j]=='R'){
                    rx = i;
                    ry =j;
                } else if (board[i][j]=='B'){
                    bx=i;
                    by=j;
                }
            }
        }

        queue.offer(new Ball(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by]=true;
        System.out.println(BFS());

    }

    public static int BFS(){


       while(!queue.isEmpty()){
           Ball ball = queue.poll();
           int rx = ball.rx;
           int ry = ball.ry;
           int bx = ball.bx;
           int by = ball.by;
           int cnt = ball.cnt; //기울이기 횟수

           int tempRx = ball.rx;
           int tempRy = ball.ry;
           int tempBx = ball.bx;
           int tempBy = ball.by;

           if(cnt>10) return -1;

           for (int i=1; i<5; i++){ //상좌하우 기울이기
               boolean redHall=false;
               boolean blueHall=false;
               tempRx = rx;
               tempRy = ry;
               tempBx = bx;
               tempBy = by;

               if(board[rx+dx[i]][ry+dy[i]]!='#'){ //기울이기 레드


                   while(board[tempRx+dx[i]][tempRy+dy[i]]!='#'){
                       tempRx = tempRx + dx[i];
                       tempRy = tempRy + dy[i];

                       if(board[tempRx][tempRy]=='O'){
                           redHall=true;
                           break;
                       }
                   }
               }

               if(board[bx+dx[i]][by+dy[i]]!='#'){ //기울이기 블루


                   while(board[tempBx+dx[i]][tempBy+dy[i]]!='#'){
                       tempBx = tempBx + dx[i];
                       tempBy = tempBy + dy[i];
                       if(board[tempBx][tempBy]=='O'){
                           blueHall=true;
                           break;
                       }
                   }

               }

               if(redHall && !blueHall){
                   return cnt+1;
               }
               if(blueHall){
                   continue;
               }
               //겹쳤을 때 위치 조정

               if(tempRx==tempBx && tempRy==tempBy){
                   // 상 좌 하 우
                   if(i==1){
                       if(rx<bx){
                           //B를 한칸 밑으로
                           tempBx-=dx[i];
                       } else {
                           tempRx-=dx[i];
                       }
                   } else if (i==2){
                       if(ry<by){
                           //B를 한칸 오른쪽으로
                           tempBy -= dy[i];
                       } else{
                           tempRy-=dy[i];
                       }

                   } else if (i==3){
                       if(rx>bx){
                           //B를 한칸 위로
                           tempBx-=dx[i];
                       } else {
                           tempRx-=dx[i];
                       }
                   } else if (i==4){
                       if(ry>by){
                           //B를 한칸 왼쪽으로
                           tempBy -= dy[i];
                       } else {
                           tempRy -= dy[i];
                       }
                   }

               }
               //겹치지 않았을 땐 그냥 넣기
               if(!visited[tempRx][tempRy][tempBx][tempBy]){
                   visited[tempRx][tempRy][tempBx][tempBy]=true;
                   queue.offer(new Ball(tempRx, tempRy, tempBx, tempBy, cnt + 1));
               }
           }
       }

       return -1;
    }

    public static boolean isRange(int nx ,int ny){
        return (nx >= 0 && nx < R && ny >= 0 && ny < C);
    }
}
