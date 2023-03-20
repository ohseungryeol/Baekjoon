import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            String tmp = br.readLine();
            IsVPS(tmp);
        }
    }

    public static void IsVPS(String tmp){
        Stack<Character> stack = new Stack<>();
        char[] ch = tmp.toCharArray();

        for (int i=0; i<ch.length; i++){
            if (ch[i]=='('){
                stack.push(ch[i]);
            } else if (ch[i]==')'){
                if(stack.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }

    }
}