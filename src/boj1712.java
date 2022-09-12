import java.util.Scanner;

public class boj1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 고정비용
        int B = sc.nextInt(); // 가변비용
        int C = sc.nextInt(); //노트북 한대당 판매가격

        int i=1;


        if (B>=C){
            i= -1;
        } else{
            i = A/(C-B)+1;
        }

        System.out.println(i);
    }
}
