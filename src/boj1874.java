import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class boj1874 {
    public static Stack<Integer> stack = new Stack<>();// 수열을 만들기 위해 1 ~ N 까지의 수가 저장될 스택
    public static int N;                // 입력받을 수열의 크기
    public static int num = 1;            // 수열을 만들기 위해 1 ~ N가 되는 수

    public static int[] arr;            // 입력받을 수열이 저장될 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N];
        int[] result = new int[N];
        StringBuilder sb = new StringBuilder();
        boolean flag =true;
        int k=0;
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            while(num<=arr[i]){
                stack.push(num);
                sb.append('+').append('\n');
                num++;
            }
            if (num>arr[i]){
                while(!stack.empty()&& stack.peek()>=arr[i]){
                    result[k]=stack.pop();
                    k++;
                    sb.append('-').append('\n');
                }
            }
        }

        if(Arrays.equals(arr,result)){
            System.out.print(sb);
        } else{
            System.out.println("NO");
        }




    }


}
