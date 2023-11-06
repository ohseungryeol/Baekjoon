package DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class boj2493 {
    static class Info{
        int height;
        int num;

        public Info(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N + 1];
        int[] answer = new int[N + 1];
        StringBuilder sb = new StringBuilder();
        Stack<Info> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) { // 6 9 5 7 4
            top[i] = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().height<top[i]){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek().height>=top[i]) sb.append(stack.peek().num+" ");

            if(stack.isEmpty()) sb.append(0+" ");
            stack.push(new Info(top[i],i));
        }

        System.out.println(sb);

    }
}
