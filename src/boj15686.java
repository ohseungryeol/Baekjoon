import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj15686 {
    static ArrayList<int []> house = new ArrayList<>();
    static ArrayList<int []> chicken = new ArrayList<>();
    static ArrayList<Integer> chickenDistance = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1<=집의 갯수<=2N
        int M=  sc.nextInt(); // 운영해야할 치킨집의 수 M<=치킨집의 수<=13

        int[][] city = new int[N + 1][N + 1];

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                city[i][j] = sc.nextInt();
            }
        }

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if(city[i][j]==1) house.add(new int[] {i,j});
                if(city[i][j]==2) chicken.add(new int[]{i,j});
            }
        }

         boolean[] visited = new boolean[chicken.size()];
    }

    public static int MinChickenDistance(ArrayList<int []> house, ArrayList<int []> chicken, int M){
        int sum=0;
        for (int[] h: house){
            int sumDistance =0;
            int min = Integer.MAX_VALUE;
            for(int[] c: chicken){
                int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                if(distance<min) min = distance; //house1..house2.. 각각의 집에 치킨거리 코드
            }
            sum+=min;
            chickenDistance.add(sumDistance);
        }

        for (int i=0; i<chickenDistance.size(); i++){
            System.out.print(chickenDistance.get(i)+" ");
        }
        Collections.sort(chickenDistance); // 치킨거리가 최솟값인 M개를 구하기위해 정렬


        return sum;
    }
}