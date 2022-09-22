import java.util.Scanner;

public class boj1436 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int num = 1;
        int count = 0;


        while (count!=N) {
            String shhom = ""+num;

            if (shhom.contains("666")) {
                count++;
            }
            num++;
        }
        System.out.println(num-1);
    }

}
