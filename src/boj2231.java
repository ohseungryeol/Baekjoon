import java.util.Scanner;

public class boj2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int constructor = 0;
        for (int i=1; i<=N; i++){
            int sum=0;
            int firstNum=i;

            while(firstNum!=0){ //각 자릿 수를 더해준다.
                sum+= firstNum%10;
                firstNum = firstNum/10;
            }
            if(sum+i==N){
                constructor =i;
                break;
            }
        }

        System.out.println(constructor);
    }
}