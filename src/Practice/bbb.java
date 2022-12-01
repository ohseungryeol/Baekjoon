import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class bbb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[N]; //입력 받은 배열
        long[] answer = new long[3]; // 정답 값을 넣을 배열
        long min = Long.MAX_VALUE;

        st =  new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i]=Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i=0; i<N-2; i++){
            long goal = arr[i];
            int p1 = i+1;
            int p2 = N-1;

            while(p1<p2){
                long temp = arr[p1]+arr[p2];
                long sum = goal+temp;

            }
        }

        Arrays.sort(answer); //정답배열  오름차순
        System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);


    }
}
