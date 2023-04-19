import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2578 {
    static int count = 0;
    static boolean rightDownFlag = true;
    static boolean rightUpFlag = true;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] bingo = new int[5][5];



        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }

        for (int k = 1; k <= 25; k++) {
            int n = sc.nextInt();
            int x = -1;
            int y = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (bingo[i][j] == n) {
                        bingo[i][j] = 0;
                        x = i;
                        y = j;

                    }
                }
            }
            rowCheck(x,bingo);
            colCheck(y,bingo);
            if(rightDownFlag==true) {
                rightDown(bingo);
            }
            if(rightUpFlag==true) {
                rightUp(bingo);
            }


            if (count >= 3) {
                System.out.println(k);
                break;
            }
        }
    }

    public static void rowCheck(int x, int[][] bingo) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[x][i] == 0) {
                cnt++;
            }
        }
        if (cnt == 5) {
            count++;
        }
    }

    public static void colCheck(int y, int[][] bingo) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][y] == 0) {
                cnt++;
            }
        }
        if (cnt == 5) {
            count++;
        }
    }

    public static void rightDown(int[][] bingo) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                cnt++;
            }
        }
        if (cnt == 5) {
            count++;
            rightDownFlag = false;
        }
    }

    public static void rightUp(int[][] bingo) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0) {
                cnt++;
            }
        }

        if (cnt == 5) {
            count++;
            rightUpFlag=false;
        }
    }
}
