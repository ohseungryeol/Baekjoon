import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //물건의 수
        int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
        int[] W = new int[N];
        int[] V = new int[N];
        int[] dp = new int[N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            W[i]=w;
            V[i]=v;
        }
    }
}
