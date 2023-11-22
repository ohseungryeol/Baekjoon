import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int colMax=0;
        int rowMax=0;

        int[] col = new int[M];
        int[] row = new int[N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                row[i]=Math.max(row[i],board[i][j]);
                rowMax = Math.max(rowMax,row[i]);
                col[i]=Math.max(col[i],board[j][i]);
                colMax= Math.max(colMax,col[i]);
            }
        }


        int answer =0;
        int sideArea = colMax*M;
        int frontArea =rowMax*N;
        int upArea = N*M;
        Arrays.sort(row);
        Arrays.sort(col);

        for (int i=row.length-2; i>=0; i--){
            if(rowMax>row[i]) frontArea-= rowMax-row[i];
            else if(rowMax==row[i]) frontArea+=1;
        }

        for (int i=col.length-2; i>=0; i--){
            if(colMax>col[i]) sideArea-= colMax-col[i];
            else if(colMax==col[i]) sideArea+=1;
        }

        System.out.println((sideArea+upArea+frontArea)*2);

    }
}
