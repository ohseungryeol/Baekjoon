import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //정수 갯수 입력
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<N; i++){
            arr.add(Integer.parseInt(br.readLine())); //정수들 입력받기
        }

        Collections.sort(arr);

       for (int n: arr){
           sb.append(n).append('\n');
       }

        System.out.println(sb);
    }
}
