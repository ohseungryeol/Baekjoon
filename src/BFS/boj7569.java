package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7569 {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[][][] box ;
    static int answer=0;
    static Queue<int[]> queue = new LinkedList<>();
    static int x,y;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][y][x];

        for (int i=0; i<h; i++){
            for (int j=0; j<y; j++){
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<x; k++){
                    int t = Integer.parseInt(st.nextToken());
                    box[i][j][k]=t;
                    if(t==1) queue.offer(new int[]{i,j,k,0}); //층수,높이,너비,일수
                }
            }
        }



        System.out.println(BFS());

    }

    public static int BFS(){

        while(!queue.isEmpty()){
            int[] tomato = queue.poll();
            if(answer!=tomato[3]) answer = tomato[3];

            for (int i=0; i<6; i++){
                int nh = tomato[0]+dh[i];
                int ny = tomato[1]+dy[i];
                int nx = tomato[2]+dx[i];

                if(nh>=0 && nh<h && ny>=0 && ny<y && nx>=0 && nx<x && box[nh][ny][nx]==0){
                    box[nh][ny][nx]=1;
                    queue.offer(new int[]{nh,ny,nx,tomato[3]+1});
                }
            }
        }

        for (int i=0; i<h; i++){
            for (int j=0; j<y; j++){
                for (int k=0; k<x; k++){
                    if(box[i][j][k]==0) return -1;
                }
            }
        }

        return answer;
    }

}
