import java.util.Scanner;
import java.util.Stack;

public class boj10773 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        for (int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num!=0){
                stack.push(num);
            } else{
                stack.pop();
            }

        }

        for (int x: stack){
            sum+=x;
        }
        System.out.println(sum);

    }

}

