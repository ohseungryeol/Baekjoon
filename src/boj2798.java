import java.util.Scanner;

public class boj2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt(); //카드 갯수
        int M= sc.nextInt(); //딜러가 부르는 숫자
        int[] answer = new int[3];
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int sum =0;
        int max =0;
        for (int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for (int k=j+1; k<N; k++){
                    sum = arr[i]+arr[j]+arr[k];
                    if(sum==M){
                        max = sum;
                        break;
                    } else if (sum<M && max<sum) max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
