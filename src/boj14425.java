import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map = new HashMap<>();
        int answer =0;
        String tmp = "";

        for (int i=0; i<N; i++){
            String input = br.readLine();
            map.put(i,input);
        }


        for (int i=0; i<M; i++){
            String test = br.readLine();
            if (map.containsValue(test)){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
