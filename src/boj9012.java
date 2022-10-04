import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            String str = br.readLine();
            sb.append(isVPS(str)).append('\n');
        }

        System.out.print(sb);
    }

    public static String isVPS(String str){
        Stack<Character> stack = new Stack<>();
        char[] ch =str.toCharArray();

        for (int i=0; i<ch.length; i++){
            if(ch[i]=='(')  stack.push(ch[i]);
            else if (ch[i]==')'){
                if(stack.empty()){
                    stack.push(ch[i]);
                    break;
                } else{
                    stack.pop();
                }
            }
        }
        if (stack.empty()) return "YES";
        else return "NO";
    }
}