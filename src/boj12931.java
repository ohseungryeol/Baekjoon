import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj12931 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());


        int addCount=0;
        int mulMax=0;
        for (int i=0; i<N; i++){
            int mulCount=0;
            while(B[i]!=0){
                if(B[i]%2==0){
                    B[i]/=2;
                    mulCount++;
                } else {
                    B[i]-=1;
                    addCount++;
                }
            }

            //곱하기는 모든 배열에 적용이므로 최고 연산만 생각하면 됨.
            mulMax = Math.max(mulMax,mulCount);
        }
        System.out.println(mulMax+addCount);
    }
}
