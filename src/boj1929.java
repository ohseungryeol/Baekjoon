import java.util.Scanner;

public class boj1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        for (int i=M; i<=N; i++){
            if(is_Prime(i)) System.out.println(i);
        }
    }

    public static boolean is_Prime(int num){
        if (num==2) return true;
        if (num==1) return false;

        for (int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }

        return true;
    }
}
