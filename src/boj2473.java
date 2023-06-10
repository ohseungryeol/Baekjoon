import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class boj2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //3<=N<=5000

        long[] arr = new long[N]; // 배열의 각 원소는 -10억이상 10억 이하의 정수
        long[] answer = new long[3]; // 출력 값인 세 용액을 넣을 배열

        st =  new StringTokenizer(br.readLine())    ;
        for (int i=0; i<N; i++){
            arr[i]=Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long min = Long.MAX_VALUE;

        for (int i=0; i<N-2; i++){
            int fix =i; //고정 용액의 인덱스
            int p1 = i+1;
            int p2 = N-1;
            while(p1<p2){
                long sum = arr[fix]+arr[p1]+arr[p2];

                if (min>abs(sum)){
                    min=abs(sum);
                    answer[0] = arr[fix];
                    answer[1]= arr[p1];
                    answer[2] = arr[p2];
                }

                if(sum<0) p1++;
                else p2--;
            }
        }

        Arrays.sort(answer); //정답배열  오름차순
        System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);


    }
}
