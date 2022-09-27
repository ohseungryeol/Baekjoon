import java.util.Scanner;

public class boj7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row + 1][col + 1];

        for (int i=1; i<=row; i++){
            for (int j=1; j<=col; j++){
                arr[i][j] = sc.nextInt();
            }
        }

    }
}
