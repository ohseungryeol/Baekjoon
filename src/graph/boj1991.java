package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<ArrayList<Character>> tree = new ArrayList<>();
        for (int i=0; i<=N; i++){
            tree.add(new ArrayList<Character>());
        }

        for (int i=0; i<N; i++){
            String tmp = br.readLine();
            String str = tmp.replaceAll(" ","");
            char a = str.charAt(0);
            char b = str.charAt(1);
            char c = str.charAt(2);

            tree.get(a).add(b);
            tree.get(a).add(c);
        }

        System.out.println(tree.get('a'));

    }
}
