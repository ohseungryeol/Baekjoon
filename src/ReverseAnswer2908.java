import java.util.Scanner;

public class ReverseAnswer2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();

        String tmp1 = new StringBuilder(num1).reverse().toString();
        String tmp2 = new StringBuilder(num2).reverse().toString();

        int newNum1 = Integer.parseInt(tmp1);
        int newNum2 = Integer.parseInt(tmp2);

        if (newNum1>newNum2){
            System.out.println(newNum1);
        } else{
            System.out.println(newNum2);
        }



    }
}
