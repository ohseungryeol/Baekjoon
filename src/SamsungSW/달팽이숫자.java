package SamsungSW;

import java.util.Scanner;

public class 달팽이숫자 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i=1; i<=T; i++){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int[][] check = new int[N][N];
            int dir=0;
            int x=0,y=0;

            for (int j=1; j<=N*N; j++){
                //System.out.println(x+","+y);
                arr[x][y]=j;
                check[x][y]=1;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx>=0 && nx<N &&ny>=0 &&ny<N && check[nx][ny]==0){
                    x=nx;
                    y=ny;
                } else{
                    dir=(dir+1)%4; //방향을 바꾸고 x ,y 값도 다음 칸으로 갱신해야함.
                    x=x+dx[dir];
                    y=y+dy[dir];
                }
            }
            System.out.println("#"+i);
            for(int r=0; r<N; r++){
                for (int c=0; c<N; c++){
                    System.out.print(arr[r][c]+" ");
                }
                System.out.println();
            }
        }
    }


}
