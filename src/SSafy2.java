import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SSafy2 {
    static int P;
    static int[] first;
    static int[] two;
    static int answer;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test=1; test<=T; test++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken()); //연속된 화분에 똑같은 비료를 썼을 때 줄어드는 양

            int[] first = new int[N];
            int[] two = new int[N];
            //0~N-1번 화분
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) first[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) two[i] = Integer.parseInt(st.nextToken());
            answer=0;
            DFS(0,0);


            System.out.printf("#%d %d\n",test,answer);
        }
    }

    public static void DFS(int L,int sum){
        if(L==N) {
            answer = Math.max(answer,sum);
            return;
        }
        DFS(L+1,sum+(first[L]-P));
        DFS(L+1,sum+two[L]);

    }
}
