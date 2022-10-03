import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj10828 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] str = new String[N];

        for (int i=0; i<N; i++){
            str[i] = br.readLine();
            String tmp = str[i];
            if(tmp.contains(" ")){
                String[] tmp2 = tmp.split(" ");
                stack.push(Integer.parseInt(tmp2[1]));
            } else if (tmp.contains("top")){
                if(stack.empty()) sb.append(-1).append('\n');
                else sb.append(stack.peek()).append('\n');
            } else if (tmp.contains("size")){
                sb.append(stack.size()).append('\n');
            } else if (tmp.contains("pop")){
                if(stack.empty()) sb.append(-1).append('\n');
                else sb.append(stack.pop()).append('\n');
            } else if (tmp.contains("empty")){
                if(stack.empty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }

        System.out.println(sb);


    }
}
