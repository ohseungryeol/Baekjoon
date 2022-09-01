import java.util.Scanner;

public class boj2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int count =0;
        while(true){
            if (n%5 ==0){
                count = n/5;
            } else if (n%5 ==3){
                count = n/5+1;
            }
        }
    }

}

