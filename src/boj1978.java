import java.util.Scanner;

public class boj1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count =0;
       for (int i=0; i<n; i++){
           int num = sc.nextInt();
           boolean is_prime = true;
           if(num==1) continue;
           for (int j=2; j<=Math.sqrt(num); j++){
               if(num%j ==0) is_prime = false;
           }
           if (is_prime==true) count++;
       }
        System.out.println(count);



    }

 }

