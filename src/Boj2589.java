import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2589 {
    static char[][] map;
    static int R;
    static int C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] points = new int[2];
    static int answer = Integer.MIN_VALUE;
    // 조합 1차원 배열
    static boolean[] visited;
    // 2차원 방문 여부 배열
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R * C];
        for (int i=0; i<R; i++){
            String tmp = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        Combi(0, 0);
        System.out.println(answer);
    }

    public static void Combi(int L, int start){
        if(L==2){
            check = new boolean[R][C];
            // BFS 로직
            BFS(points,check);
            return;
        }
        for (int i=start; i<R*C; i++){
            if(!visited[i] && map[i/C][i%C]=='L'){
                visited[i]=true;
                points[L]=i;
                Combi(L+1,start+1);
                visited[i]=false;
            }
        }
    }

    public static void BFS(int[] points, boolean[][] check){
        Queue<int[]> queue = new LinkedList<>();
        int startX = points[0]/C;
        int startY = points[0]%C;

        check[startX][startY]=true;

        queue.offer(new int[]{startX, startY, 0});
        // 목표 좌표
        int endX = points[1]/C;
        int endY = points[1]%C;

        // 두 육지간에 최단거리에 있어서 가장 먼 거리
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            // 거리 변수
            int count = tmp[2];

            if(tmp[0]==endX && tmp[1]==endY){
                answer = Math.max(answer, count);
                break;
            }

            for (int i=0; i<4; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];

                if(isRange(nx,ny) && !check[nx][ny] && map[nx][ny]=='L'){
                    check[nx][ny]=true;
                    queue.offer(new int[]{nx, ny, count + 1});
                }
            }
        }
    }

    public static boolean isRange(int nx ,int ny){
        return (nx>=0 && nx<R && ny>=0 && ny<C);
    }
}
