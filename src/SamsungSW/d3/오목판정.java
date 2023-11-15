package SamsungSW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목판정 {
    static int N;
    static char[][] map;
    static boolean isOmok;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int test=1; test<=T; test++){
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i=0; i<N; i++){
                String tmp = br.readLine();
                for (int j=0; j<N; j++){
                    map[i][j] = tmp.charAt(j);
                }
            }
            if(solve()){
                System.out.printf("#%d %s\n",test,"YES");
            } else {
                System.out.printf("#%d %s\n",test,"NO");
            }
        }
    }

    public static boolean solve(){
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(map[i][j]=='o'){
                    // dfs 호출
                    for (int k=0; k<8; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(isRange(nx,ny)) {
                            isOmok = false;
                          //  System.out.println("첫 DFS 호출"+i+","+j+" d="+k);
                            DFS(nx, ny, k, 1);
                            if (isOmok) return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void DFS(int x, int y,int k,int cnt){
       // System.out.println("DFS 호출"+x+","+y+",cnt="+cnt);
        if(map[x][y]!='o') return;
        if(cnt>=4){
            isOmok=true;
            return;
        }

        int nx = x+dx[k];
        int ny = y+dy[k];
        if(isRange(nx,ny)){
            DFS(nx,ny,k,cnt+1);
        }
    }


    public static boolean isRange(int nx, int ny){
        if(nx>=0 && nx<N && ny>=0 && ny<N) return true;
        return false;
    }
}
