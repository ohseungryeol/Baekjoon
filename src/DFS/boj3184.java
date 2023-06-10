package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3184 {
    static int r,c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int wolf;
    static int sheep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int answerSheep = 0, answerWolf = 0;

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i=0; i<r; i++){
            String tmp = br.readLine();
            for (int j=0; j<c; j++){
                map[i][j]=tmp.charAt(j);
                if(map[i][j]=='v') answerWolf++;
                if(map[i][j]=='o') answerSheep++;
            }
        }



        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if(map[i][j]!='#' && !visited[i][j]){
                    sheep=wolf=0;
                    DFS(i,j);
                  //  System.out.printf("i=%d j=%d wolf=%d sheep=%d\n",i,j,wolf,sheep);
                    if(sheep<=wolf){
                        answerSheep-=sheep;
                    } else{
                        answerWolf-=wolf;
                    }
                }
            }
        }

        System.out.println(answerSheep+" "+answerWolf);
    }

    public static void DFS(int x,int y){
        visited[x][y]=true;
        if(map[x][y]=='o') sheep++;
        if(map[x][y]=='v') wolf++;

        for (int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<r && ny>=0 && ny<c ){
                if(visited[nx][ny] || map[nx][ny]=='#') continue;
                DFS(nx,ny);
            }

        }
    }
}
