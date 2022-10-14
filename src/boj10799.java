import java.util.Scanner;
import java.util.Stack;

public class boj10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        int Laser =0;
        int result =0;
        int[] check = new int[ch.length];


        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<ch.length; i++){
            int count=0;
            if (ch[i]=='(') stack.push(i);

            if (ch[i]==')'){
                if (ch[i-1]=='('){ //레이저일때
                    stack.pop();
                    check[i]++;
                } else{ // 쇠막대기일때
                    int x = stack.pop();
                    for (int j=x; j<=i;j++){
                        if (check[j]==1) count++;
                    }
                    result = result+(count+1);

                }
            }
        }

        System.out.println(result);

    }
}
