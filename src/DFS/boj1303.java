package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1303 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static char[][] map;
    static int count;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String tmp = br.readLine();
            for (int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        int pow_W=0;
        int pow_B=0;

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(!visited[i][j]){
                    count=0;
                    if(map[i][j]=='W'){
                        visited[i][j]=true;
                        DFS(i,j,'W');
                        pow_W+=count*count;
                    } else {
                        visited[i][j]=true;
                        DFS(i,j,'B');
                        pow_B+=count*count;
                    }
                }
            }
        }

        System.out.println(pow_W+" "+pow_B);
    }

    public static void DFS(int x, int y, char c){

        count++;
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx,ny) && map[nx][ny]==c && !visited[nx][ny]){
                visited[nx][ny]=true;
                DFS(nx,ny,c);
            }
        }
    }

    public static boolean isRange(int nx, int ny){
        return (nx>=0 && nx<N && ny>=0 && ny<M);
    }
}
