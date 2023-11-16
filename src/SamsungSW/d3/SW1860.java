package SamsungSW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test=1; test<=T; test++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //사람 수
            //M초당 K개의 붕어빵을 만든다 .
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
            int cookTime=0;
            Arrays.sort(arr);

            boolean flag = true;
            int fish=0;
            int j=1;
            if(arr[1]==0) flag = false;
            for (int i=1; i<=arr[N]; i++){ //i가 시간초N
                if(i%M==0) fish+=K; //초마다 붕어빵 만듬
                //System.out.printf("i=%d fish=%d\n",i,fish);
                if(i==arr[j]){
                   // System.out.println(arr[j]);
                    if(fish==0){
                        flag = false;
                        break;
                    }
                    j++;
                    fish-=1;
                }
                if(j>N) break;
            }

            if(flag==true){
                System.out.printf("#%d %s\n", test,"Possible");
            } else {
                System.out.printf("#%d %s\n", test,"Impossible");
            }
        }
    }
}
