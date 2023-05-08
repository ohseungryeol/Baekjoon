package SamsungSW;

import java.util.Scanner;

public class 백만장자프로젝트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i=1; i<=T; i++){
            int N = sc.nextInt();
            int[] arr= new int[N];
            for (int j=0; j<N; j++){
                int num = sc.nextInt();
                arr[j]=num;
            }
            int max = Integer.MIN_VALUE;
            long diff=0;
           /* for (int k=N-1; k>=0; k--){
                if(max<arr[k]){
                    max = arr[k];
                } else{
                    diff+=max-arr[k];
                }
            }*/

            for (int k=0; k<N; k++){
                if(arr[k]>max){
                    max = arr[k];
                }
            }

            System.out.printf("#%d %d\n",i,diff);
        }
    }
}
