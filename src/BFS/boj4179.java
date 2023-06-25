package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj4179 {
    static int R,C;
    static char[][] miro;
    static int answer=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static Queue<Point> Jqueue = new LinkedList<>();
    static Queue<Point> FQueue = new LinkedList<>();

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        /*#: 벽
    .: 지나갈 수 있는 공간
    J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
    F: 불이 난 공간*/
        //지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.
        //지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다.
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        miro = new char[R][C];
        visited = new boolean[R][C];
        for (int i=0; i<R; i++){
            String tmp = sc.next();
            for (int j=0; j<C; j++){
                miro[i][j]=tmp.charAt(j);
            }
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(miro[i][j]=='J'){
                    Jqueue.offer(new Point(i, j));
                } else if (miro[i][j]=='F') FQueue.offer(new Point(i, j));
            }
        }

        BFS();
        if(answer==0){
            System.out.println("IMPOSSIBLE");
        }

    }

    public static void BFS(){
        int cnt = 0;
        while(!Jqueue.isEmpty()){
            int fireSize = FQueue.size();
            for (int i=0; i<fireSize; i++){
                Point nowF = FQueue.poll();
                for (int j=0; j<4; j++){
                    int nx = nowF.x+dx[j];
                    int ny = nowF.y+dy[j];

                    // 범위를 벗어나면 pass
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    // 벽이거나 방문한 곳이면 pass
                    if(miro[nx][ny] == '#' || miro[nx][ny] == 'F') continue;
                    miro[nx][ny]='F';
                    FQueue.offer(new Point(nx, ny));
                }
            }

            int jSize = Jqueue.size();
            for (int i=0; i<jSize; i++){
                Point nowJ = Jqueue.poll();
                for (int j=0; j<4; j++){
                    int nx = nowJ.x+dx[j];
                    int ny = nowJ.y+dy[j];

                    if(nx<0 || nx>=R || ny<0 || ny>=C){
                        System.out.println(++answer);
                        return;
                    }
                    // 벽이거나 불이거나 방문한 곳이면 pass
                    if(miro[nx][ny] == '#' || miro[nx][ny] == 'F' || miro[nx][ny] == 'J') continue;

                    miro[nx][ny] = 'J';
                    answer++;
                    Jqueue.offer(new Point(nx,ny));

                }
            }
        }
    }


}
