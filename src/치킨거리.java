import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨거리 {
    static int[][] map;
    static int N,M;
    static boolean[] check;
    static int answer = Integer.MAX_VALUE;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)houses.add(new Point(i,j));
                else if (map[i][j]==2) chickens.add(new Point(i, j));
            }
        }
        check = new boolean[chickens.size()];
        Combi(0,0);
        System.out.println(answer);
        /*
        * 치킨거리 = 집과 가장 가까운 치킨집 사이의 거리(집 기준) 1= 집 2= 치킨집
          도시의 치킨거리 = 모든 집의 치킨 거리의 합
          치킨집 M개를 골랐을 때 도시의 치킨거리 최솟값 구하기
        * */
    }

    public static void Combi(int count,int L){
        if(count==M){
            int distance = calcDistance(check);
            answer=Math.min(answer,distance);
            return;
        }
        for (int i=L; i<chickens.size(); i++){
            if(!check[i]){
                check[i]=true;
                Combi(count+1,i);
                check[i]=false;
            }
        }
    }

    public static int calcDistance(boolean[] check){
        /*

        0 2 0 1 0
        1 0 1 0 0
        0 0 0 0 0
        2 0 0 1 1
        2 2 0 1 2

 */
        int cityTotalDistance=0;
        //집과 가장가까운 치킨집을 구한다.
        for (Point house:houses){ //각 집
            int minSum=Integer.MAX_VALUE;
            for (int i=0; i< check.length; i++){ //각 치킨집
                if(check[i]==true) { //선택된 치킨집이라면 그 선택된 치킨집중에 최소거리를 구한다.
                    if (Math.abs(house.x - chickens.get(i).x) + Math.abs(house.y - chickens.get(i).y) < minSum) {
                        minSum = Math.abs(house.x - chickens.get(i).x) + Math.abs(house.y - chickens.get(i).y);
                    }
                }
            }
            cityTotalDistance+=minSum;
        }

        return cityTotalDistance;
    }
}
