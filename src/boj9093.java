import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++){
            String str = br.readLine();
            String[] tmp = str.split(" ");
            for (int j=0; j<tmp.length; j++){
                StringBuilder sb = new StringBuilder(tmp[j]);
                System.out.print(sb.reverse().toString()+" ");
            }
            System.out.println();
        }
    }
}
