import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj2630 {
    static int white=0;
    static int blue =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        int[][] board = new int[N][N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Divide(board,N,0,0);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void Divide(int[][] board, int N,int r, int c ){


        int mid = N/2;
        if(colorCheck(r,c,board,N)){
            if(board[r][c]==0) white++;
            else blue++;
            return;
        }

        if( N==1) return;
        Divide(board,mid,r,c);
        Divide(board,mid,r + mid,c);
        Divide(board,mid,r,c + mid);
        Divide(board,mid,r+mid,c+mid);
    }
    //3
    public static boolean colorCheck(int row, int col,int[][] board,int mid){
        boolean flag = true; // 흰색
        int first = board[row][col];
        for (int i=row; i<row+mid; i++){
            for (int j=col; j<col+mid; j++){
                if(board[i][j]!=first) return false;
            }
        }

        return true;
    }
}
