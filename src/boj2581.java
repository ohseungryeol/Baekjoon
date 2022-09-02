import java.util.Scanner;

public class boj2581 {
    // M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum=0;
        int min=10000;
        for (int i=M; i<=N; i++){
            if (is_Prime(i)){
                sum+=i;
                if(i<min) min=i;
            }
        }
        if(sum==0){
            System.out.println(-1);
        } else{
            System.out.println(sum);
            System.out.println(min);
        }


    }

    public static boolean is_Prime(int num){
        if (num==1) return false;
        if (num==2) return true;

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }

        return true;
    }
}
