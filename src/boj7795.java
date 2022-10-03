import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7795 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int p1 =0;
            int p2 =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] Asize = new int[A];
            int[] Bsize = new int[B];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A; j++) // A 사이즈 입력
                Asize[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<B; k++) // B 사이즈 입력
                Bsize[k] = Integer.parseInt(st.nextToken());

            Arrays.sort(Asize); // 배열 정렬
            Arrays.sort(Bsize);
            int count = 0;
            System.out.println(count);
        }
    }
}

