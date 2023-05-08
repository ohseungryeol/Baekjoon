package BFS;
import java.util.*;
import java.util.Scanner;

public class sss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(); // 가로 크기
        int h = sc.nextInt(); // 세로 크기
        int x1 = sc.nextInt(); // 대각선 있는 점 1의 x 좌표
        int y1 = sc.nextInt(); // 대각선 있는 점 1의 y 좌표
        int x2 = sc.nextInt(); // 대각선 있는 점 2의 x 좌표
        int y2 = sc.nextInt(); // 대각선 있는 점 2의 y 좌표
        int dx = Math.abs(x1 - x2); // 대각선의 가로 길이
        int dy = Math.abs(y1 - y2); // 대각선의 세로 길이
        int gcd = getGCD(dx, dy); // 대각선의 가로, 세로 길이의 최대공약수
        int count = 0; // 최단 경로의 경우의 수
        for (int i = 0; i <= gcd; i++) {
            int x = dx / gcd * i; // 대각선 위의 점의 x 좌표
            int y = dy / gcd * i; // 대각선 위의 점의 y 좌표
            if (isOnDiagonal(x1, y1, x2, y2, x, y)) {
                count += combination(gcd, i); // 경우의 수 계산
            }
        }
        System.out.println(count);
    }

    // 최대공약수를 구하는 메서드
    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }

    // 점이 대각선 위에 있는지 확인하는 메서드
    public static boolean isOnDiagonal(int x1, int y1, int x2, int y2, int x, int y) {
        int crossProduct = (x - x1) * (y2 - y1) - (x2 - x1) * (y - y1);
        return crossProduct == 0;
    }

    // 조합을 계산하는 메서드
    public static int combination(int n, int k) {
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result *= (n - i + 1);
            result /= i;
        }
        return result;
    }
}

