package WEEK1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1987
public class nog {
    static int R, C, max; //세로, 가로, 출력값
    static String[][] arr;
    //static boolean[][] visited;
    static String alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R+1][C+1];
        //visited = new boolean[R+1][C+1];

        /*
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                arr[i][j] = st.nextToken();
            }
        }
        */

        for(int i=1; i<=R; i++)
            arr[i] = br.readLine().split("");

        alphabet = arr[1][1];
        dfs(1,1, alphabet, 1); // 1행 1열
        System.out.println(max);
    }

    public static void dfs(int i, int j, String alphabet, int cnt){
        //visited[1][1] = true; // 1행 1열부터 시작
        //String[] check = new String[26]; // 크기) 알파벳갯수 -> 최대값으로 지정

            if (i-1>0 &&!alphabet.contains(arr[i - 1][j])) { //상 : i-1 >= 1
                dfs(i - 1, j, alphabet + arr[i - 1][j], cnt + 1);
            }
            if (i+1<=R && !alphabet.contains(arr[i + 1][j])) { //하 : i+1 <= R
                dfs(i + 1, j, alphabet + arr[i + 1][j], cnt + 1);
            }
            if (j-1>0 &&!alphabet.contains(arr[i][j - 1])) { //좌 : j-1 >= 1
                dfs(i, j - 1, alphabet + arr[i][j - 1], cnt + 1);
            }
            if (j+1 <=C && !alphabet.contains(arr[i][j + 1])) { //우 : j <= C-1
                System.out.println(alphabet);
                dfs(i, j + 1, alphabet + arr[i][j + 1], cnt + 1);
            }


        max = Math.max(cnt, max);
    }

}