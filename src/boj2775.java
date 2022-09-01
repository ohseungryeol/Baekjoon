import java.util.Scanner;

public class boj2775 {
    public static int apartment(int k, int n){ //k층 n호
        if (n==1){
            return 1;
        }
        if (k==0){
            return n;
        }

        return apartment(k,n-1)+apartment(k-1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            int k =sc.nextInt();
            int n= sc.nextInt();
            System.out.println(apartment(k,n));
        }


    }
}
