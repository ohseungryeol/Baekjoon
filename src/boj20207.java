import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj20207 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 일정 갯수
        int[] dup = new int[366];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j=s; j<=e; j++){
                dup[j]++;
            }
        }

        int sum=0;
        int width=0;
        int height=0;

        for (int i=0; i<=365; i++){
            height = Math.max(height,dup[i]);
            if(dup[i]==0){
                sum+=width*height;
                width=0;
                height=0;
                continue;
            } else{
                width++;
            }
        }
        sum+=width*height;
        System.out.println(sum);

    }
}
