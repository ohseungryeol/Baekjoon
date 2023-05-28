package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj2667 {
    static int answer=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int[][] board;
    static int n;
    static int apartNum=0;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++){
            String input = sc.next();
            for (int j=0; j<n; j++){
                board[i][j]=Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }




        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(board[i][j]==1 && visited[i][j]==false){
                    DFS(i, j);
                    arr.add(apartNum);
                    answer++;
                    apartNum=0;
                }
            }
        }

        System.out.println(answer);
        Collections.sort(arr);

        for (int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }

    //총 단지 수 출력, 각 단지내 집의 수를 오름차순으로 출력
    public static void DFS(int x, int y){
        visited[x][y]=true;
        apartNum++;
        for (int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1 && visited[nx][ny]==false){
                DFS(nx,ny);
            }
        }
    }
}
