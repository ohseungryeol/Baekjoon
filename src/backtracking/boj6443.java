package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class boj6443 {
    static char[] answer;
    static int[] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String tmp = br.readLine();
            char[] ch = new char[tmp.length()];
            answer = new char[tmp.length()];
            check = new int[tmp.length()];
            sb = new StringBuilder();
            for (int j=0; j<tmp.length(); j++){
                ch[j]=tmp.charAt(j);
            }
            Arrays.sort(ch);
            DFS(0,ch);
            System.out.print(sb);
        }
    }

    public static void DFS(int L, char[] ch){
        if(L==ch.length){
            for(char c: answer){
                sb.append(c);
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<ch.length; i++){
            if(check[i]==0) {
                check[i]=1;
                answer[L] = ch[i];
                DFS(L + 1, ch);
                check[i]=0;
            }
        }
    }
}
