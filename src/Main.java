import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10001]; // 수는 10000보다 같거나 작은 자연수

        for(int i=0; i<n; i++){
            arr[Integer.parseInt(br.readLine())]++; // 입력받은 수의 인덱스 값을 1증가
        }

        for(int i=1; i<10001; i++){ // 자연수이므로 1부터 시작
            while(arr[i]>0){ // 해당 인덱스 값의 수(빈도수)가 0이 될때까지 1씩 감소하며 출력
                sb.append(i+"\n");
                arr[i]--;
            }
        }
        System.out.println(sb);
    }
}