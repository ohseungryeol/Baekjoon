package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15686 {
    static ArrayList<Point> chickens = new ArrayList<>();
    static ArrayList<Point> homes = new ArrayList<>();
    static int N,M;
    static int[][] city;
    static int answer = Integer.MAX_VALUE;
    static Point[] selectedChickens;
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N*N 도시
        M = Integer.parseInt(st.nextToken()); // 뽑을 치킨집 갯수
        city = new int[N + 1][N + 1];
        selectedChickens = new Point[M];


        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j]==1){
                    homes.add(new Point(i,j));
                } else if (city[i][j]==2){
                    chickens.add(new Point(i,j));
                }
            }
        }

        boolean[] visited = new boolean[chickens.size()];
        combination(0,0,visited);
        System.out.println(answer);
    }

    //M개의 치킨집을 선택할 모든 경우의 수 탐색
    public static void combination(int L, int start,boolean[] visited){

        if(L==M){
            answer=Math.min(answer,getAllDistance(selectedChickens));
            return;
        }

        for (int i=start; i<chickens.size(); i++){
            if(!visited[i]){
                visited[i]=true;
                selectedChickens[L]=chickens.get(i);
                combination(L+1,i+1,visited);
                visited[i]=false;
            }
        }

    }

    public static int getAllDistance(Point[] selectedChickens){
        int distanceChickensAll = 0;
        for (int i=0; i<homes.size(); i++){
            //일단 선택된 치킨집들 중에서도 제일 가까운 치킨집을 각 집별로 찾아야한다.
            Point hPoint = homes.get(i);
            int min =Integer.MAX_VALUE;
            for (int j=0; j< selectedChickens.length; j++){
                int tmpDistance = Math.abs(hPoint.x-selectedChickens[j].x)+Math.abs(hPoint.y-selectedChickens[j].y);
                if(min>tmpDistance) min = tmpDistance;
            }
            distanceChickensAll+=min;
        }

        return distanceChickensAll;
    }
}
