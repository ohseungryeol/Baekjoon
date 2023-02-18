import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj1620 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //포켓몬 갯수
        M = Integer.parseInt(st.nextToken()); //맞춰야하는 문제 갯수

        HashMap<String, Integer> map = new HashMap<>();
        String[] name = new String[N + 1];
        for (int i=1; i<=N; i++){
            String str = br.readLine();
            map.put(str, i);
            name[i]=str;
        }



        for (int i=0; i<M; i++){
            String str = br.readLine();
            if (IsInteger(str)){
                System.out.println(name[Integer.parseInt(str)]);
            } else{
                System.out.println(map.get(str));
            }
        }

    }

    public static boolean IsInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }


}
