import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15683 {
    static int R,C;
    static int[][] map = new int[R][C];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 cctv: 4가지 경우 (좌) (우) (상) 하
        // 2번 cctv: 2가지 경우 (좌,우) (상,하)
        // 3번 cctv: 4가지 경우 (상,좌) (좌,하) (하,우) (우,상)
        // 4번 cctv: 4가지 경우 (상,좌,하) (좌,하,우) (하,우,좌) (우,상,좌)
        // 5번 cctv: 1가지 경우 (상,하,좌,우)
    }

    public static void DFS(int cctv, int x, int y){

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){

            }
        }
    }

    public static void left(int x, int y){
        // left는 열이 1칸씩 줄어든다. 행은 그대로
        for (int i=y; i>=0; i--){
            if(map[x][i]==6) break;
            if(map[x][i]==0) map[x][i]=-1;
        }
    }

    public static void right(int x,int y){
        //right는 열이 1칸씩 증가 행은 그대로
        for (int i=y; i<C; i++){
            if(map[x][i]==6) break;
            if(map[x][i]==0) map[x][i]=-1;
        }
    }

    public static void up(int x, int y){
        // up은 행이 1칸씩 감소 열은 그대로
        for (int i=x; i>=0; i--){
            if(map[i][y]==6) break;
            if(map[i][y]==0) map[i][y]=-1;
        }
    }

    public static void down(int x, int y){
        // down은 행이 1칸씩  증가 열은 그대로
        for (int i=x; i<R; i++){
            if(map[i][y]==6) break;
            if(map[i][y]==0) map[i][y]=-1;
        }
    }
}
