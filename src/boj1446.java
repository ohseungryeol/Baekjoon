import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1446 {
    static int D;
    static int N;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] dp = new int[D + 1];
    static List<Point> arr = new ArrayList<>();
    static class Point{
        int start;
        int end;
        int distance;

        public Point(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //지름길 갯수
        D = Integer.parseInt(st.nextToken()); //총 도로길이



        dp[0]=0;
        dp[1]=1;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            arr.add(new Point(start, end, distance));
        }
        DFS(0,0);
        System.out.println(answer);
    }

    public static int DFS(int dis,int sum){
        System.out.printf("DFS(%d %d)\n",dis,sum);

        if(dis==D){
            return dp[dis]=Math.min(answer,sum);
        }
        if(dis>D) return 0    ;

        for (int i=0; i<arr.size(); i++){
            Point tmp = arr.get(i);


            if(tmp.start==dis){
                DFS(dis + tmp.end - tmp.start, sum + tmp.distance);
            }
        }

        return dp[dis] = DFS(dis+1,sum+1);
    }
}
