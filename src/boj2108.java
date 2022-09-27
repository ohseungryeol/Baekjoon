import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2108 {
    public static void main(String[] args) throws IOException {
        //평균값
        //중앙값 (오름차순했을때 중앙)
        //최빈값 (가장 많이 나온 숫자) 만약 가장 많이 나온 숫자가 여러개이면 두번째로 작은 값
        //최댓값과 최솟값의 차이
        int sum=0;
        int mid;
        int FreqValue = 0;
        int range;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001];
        for (int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            count[x+4000]++;
        }

        for (int i=0; i<N; i++){
            sum += arr[i];
        }

        Arrays.sort(arr);
        int max =0;

        boolean flag = false;
        for (int i=0; i<8001; i++){
            int max_index = -4000;
            if(count[i]>max){
                max = count[i];
                max_index = max_index+i;
                FreqValue = max_index;
                flag = true;
            } else if (count[i]==max && flag==true){
                max_index = max_index+i;
                FreqValue = max_index;
                flag = false;
            }
        }




        mid = arr[arr.length / 2]; // 중앙값
        range = arr[arr.length-1] - arr[0];

        System.out.println((int)Math.round((double)sum / N));
        System.out.println(mid);
        System.out.println(FreqValue);
        System.out.println(range);



    }
}
