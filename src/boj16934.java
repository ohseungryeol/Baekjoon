import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj16934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            String tmp = br.readLine();
            //map.put(tmp, map.getOrDefault(tmp,0)+1);
        }
    }
}
