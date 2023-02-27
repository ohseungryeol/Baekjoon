import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        polomino(str);
    }

    public static void polomino(String n) {
        String a = "AAAA";
        String b = "BB";
        n=n.replaceAll("XXXX", a);
        n=n.replaceAll("XX", b);

        if(n.contains("X")){
            System.out.println(-1);
            return;
        }

        System.out.println(n);
    }
}
