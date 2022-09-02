import java.util.Random;
import java.util.Scanner;

public class boj4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            int cnt=0;
            if (n==0) break;
            for (int i=n+1; i<=n*2; i++){
                if(is_Prime(i)) cnt++;
            }
            System.out.println(cnt);
        }

    }

    public static boolean is_Prime(int num){
        if(num==1) return false;
        if(num==2) return true;

        for (int i=2; i<=Math.sqrt(num); i++){
            if (num%i==0) return false;
        }

        return true;

    }
}
