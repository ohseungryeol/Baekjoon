package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502 {
    static int turn=0;
    static int R;
    static int C;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                   // queue.offer(new int[]{i,j});
                }
            }
        }

        /*벽을 3개 세운다음 안전영역의 최댓값을 구한다.
         * 안전영역 갯수를 세는 함수. */
        Combination(0);
        System.out.println(answer);

    }

    public static void Combination(int L){
        if(L==3){
            BFS();
            return;
        }

        for(int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    Combination(L+1);
                    map[i][j]=0;
                }
            }
        }

    }

    public static void BFS(){
        int[][] virusMap = new int[R][C];
      /*  for(int i = 0; i < map.length; i++) {
            virusMap[i] = map[i].clone();
        }*/
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                virusMap[i][j]=map[i][j];
                if(virusMap[i][j]==2) queue.offer(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] virus = queue.poll();

            for (int i=0; i<4; i++){
                int nx = virus[0]+dx[i];
                int ny = virus[1]+dy[i];


                if(isRange(nx,ny) && virusMap[nx][ny]==0){
                    virusMap[nx][ny]=2;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }

        answer = Math.max(answer,safeCount(virusMap));

    }



    public static boolean isRange(int nx, int ny){
        if(nx>=0 && nx<R && ny>=0 && ny<C){
            return true;
        }

        return false;
    }

    public static int safeCount(int[][] virusMap){
        int cnt =0;
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(virusMap[i][j]==0){
                   cnt++;
                }
            }
        }

        return cnt;
    }
}
