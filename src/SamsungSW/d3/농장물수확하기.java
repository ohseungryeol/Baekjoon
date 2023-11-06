package SamsungSW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농장물수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=1; i<=T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int r=0; r<N; r++){
                String tmp = br.readLine();
                for (int c=0; c<N; c++){
                    arr[r][c]=Integer.parseInt(String.valueOf(tmp.charAt(c)));
                }
            }

            int mid = N/2;
            int left = mid-1;
            int right = mid+1;
            int sum=0;
            for (int j=0; j<=mid; j++){
                if(j==0){
                    sum+=arr[j][mid];
                } else {
                    for (int s=left; s<=right; s++){
                        sum+=arr[j][s];
                    }
                    if(j==mid){
                        left++;
                        right--;
                        break;
                    }
                    left--;
                    right++;
                }
            }

            for (int k=mid+1; k<N; k++){
                if(k==N-1){
                    sum+=arr[k][mid];
                    break;
                }
                for (int s=left; s<=right; s++){
                    sum+=arr[k][s];
                }
                left++;
                right--;
            }

            if(N==1){
                sum=arr[0][mid];
            }
            System.out.printf("#%d %d\n",i,sum);
        }
    }
}
