import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1245 {
    static int R,C;
    static int dx[]= {-1,1,0,0,1,1,-1,-1};
    static int dy[]= {0,0,-1,1,1,-1,1,-1};
    static int[][] map;
    static boolean isPeak;
    static int answer=0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        map = new int[R][C];

        for (int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(!visited[i][j]){
                    isPeak = true;
                    DFS(i,j);
                    if(isPeak) answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int x, int y){
        for (int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRange(nx,ny)){
                // 더 높은 산이 존재
                if(map[nx][ny]>map[x][y]){
                        isPeak=false;
                }
                //
                if(!visited[nx][ny] && map[nx][ny]==map[x][y]){
                    visited[nx][ny]=true;
                    DFS(nx,ny);
                }
            }
        }
    }

    public static boolean isRange(int nx ,int ny){
        if(nx>=0 && nx<R && ny>=0 && ny<C) return true;
        return false;
    }
}
