package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15683 {
    static int R,C;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static class Point{
        int x;
        int y;
        int num;
        public Point(int x, int y,int num) {
            this.x = x;
            this.y = y;
            this.num=num;
        }

    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        boolean[][] check;
        check = new boolean[R][C];

        List<Point> arr = new ArrayList<>();

        for (int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if(num!=0) {
                    check[i][j]=true;
                    if(num!=6) arr.add(new Point(i, j, num));

                }
            }
        }

        Combination(arr,check,0);
        System.out.println(answer);

    }

    public void Combination(List<Point> arr,boolean[][] prevcheck, int L){


        if(L==arr.size()){
            int count=0;
            for (int i=0; i<R; i++){
                for (int j=0; j<C; j++){
                    if(!prevcheck[i][j]) count++;
                }
            }
            answer = Math.min(answer,count);
            return;
        }

        Point cctv = arr.get(L);
        int cctvNum = cctv.num;
        boolean[][] tmp = new boolean[R][C];
        switch (cctvNum){
            case 1:
                tmp = copyCheck(prevcheck);
                leftCheck(cctv,prevcheck);
                Combination(arr,prevcheck,L+1);

                tmp = copyCheck(prevcheck);
                downCheck(cctv,tmp);
                Combination(arr,prevcheck,L+1);

                tmp = copyCheck(prevcheck);
                rightCheck(cctv,tmp);
                Combination(arr,prevcheck,L+1);

                tmp = copyCheck(prevcheck);
                upCheck(cctv,tmp);
                Combination(arr,prevcheck,L+1);
                break;
            case 2:
                // 이전(1번) check값을 저장
                tmp = copyCheck(prevcheck);

                leftCheck(cctv,prevcheck);
                rightCheck(cctv,prevcheck);
                Combination(arr,prevcheck,L+1);
                // check 풀기
                upCheck(cctv,tmp);
                downCheck(cctv,tmp);
                Combination(arr,prevcheck,L+1);

                break;
            case 3:
                tmp = copyCheck(prevcheck);

                upCheck(cctv,prevcheck);
                leftCheck(cctv,prevcheck);
                Combination(arr,prevcheck,L+1);

                leftCheck(cctv,tmp);
                downCheck(cctv,tmp);
                Combination(arr,tmp,L+1);
                tmp = copyCheck(prevcheck);

                downCheck(cctv,tmp);
                rightCheck(cctv,tmp);
                Combination(arr,tmp,L+1);

                tmp = copyCheck(prevcheck);
                rightCheck(cctv,tmp);
                upCheck(cctv,tmp);
                Combination(arr,tmp,L+1);


                break;
            case 4:
                tmp = copyCheck(prevcheck);

                upCheck(cctv,prevcheck);
                leftCheck(cctv,prevcheck);
                downCheck(cctv,prevcheck);
                Combination(arr,prevcheck,L+1);

                leftCheck(cctv,tmp);
                downCheck(cctv,tmp);
                rightCheck(cctv,tmp);
                Combination(arr,tmp,L+1);

                tmp = copyCheck(prevcheck);

                downCheck(cctv,tmp);
                rightCheck(cctv,tmp);
                upCheck(cctv,tmp);
                Combination(arr,tmp,L+1);

                tmp = copyCheck(prevcheck);

                rightCheck(cctv,tmp);
                upCheck(cctv,tmp);
                leftCheck(cctv,tmp);
                Combination(arr,tmp,L+1);

                break;
            case 5:
                tmp = copyCheck(prevcheck);

                leftCheck(cctv,prevcheck);
                downCheck(cctv,prevcheck);
                rightCheck(cctv,prevcheck);
                upCheck(cctv,prevcheck);
                Combination(arr,prevcheck,L+1);
                break;

        }
    }

    public void leftCheck(Point point,boolean[][] check){
        int x = point.x;
        int y = point.y;

        for (int i=y-1; i>=0; i--){
            if(map[x][i]==6) return;
            if(map[x][i]!=0) continue;
            check[x][i]=true;
        }
    }
    public void downCheck(Point point, boolean[][] check){
        int x = point.x;
        int y = point.y;

        for (int i=x+1; i<R; i++){
            if(map[i][y]==6) return;
            if(map[i][y]!=0) continue;
            check[i][y]=true;
        }
    }
    public void rightCheck(Point point, boolean[][] check){
        int x = point.x;
        int y = point.y;

        for (int i=y+1; i<C; i++){
            if(map[x][i]==6) return;
            if(map[x][i]!=0) continue;
            check[x][i]=true;
        }
    }
    public void upCheck(Point point, boolean[][] check){
        int x = point.x;
        int y = point.y;

        for (int i=x-1; i>=0; i--){
            if(map[i][y]==6) return;
            if(map[i][y]!=0) continue;
            check[i][y]=true;
        }
    }

    public boolean[][] copyCheck(boolean[][] prevcheck){ //prevcheck 메개변수
        boolean[][] tmp = new boolean[R][C];

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                tmp[i][j]=prevcheck[i][j];
            }
        }

        return tmp;

    }
    public static void main(String[] args) throws IOException {
        boj15683 boj = new boj15683();
        boj.solution();
    }
}
