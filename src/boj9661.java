import java.util.Scanner;

public class boj9661 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        int temp = (int) (N%5);

        if(temp==2 || temp==5) System.out.println("CY");
        else System.out.println("SK");

    }
}
