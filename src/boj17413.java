import java.util.Scanner;
import java.util.Stack;

public class boj17413 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();

        boolean flag = false;
        for (char x: ch){
            if(x=='<'){
                flag = true; // 태그 안
                while(!stack.isEmpty()) result.append(stack.pop()); //중간 태그일땐 push해놨던걸 reverse 출력
                result.append(x);
            } else if (x == '>'){
                flag = false;
                result.append(x);
            } else if (x == ' '){
                while(!stack.isEmpty()) result.append(stack.pop());
                result.append(" ");
            }
            else{
                if (flag == true){
                    result.append(x);
                } else{ //태그 밖이면 push
                    stack.push(x);
                }
            }
        }

        while(!stack.isEmpty()){ //스택 남은 문자 뒤집음
            result.append(stack.pop());
        }
        System.out.println(result);
    }
}
