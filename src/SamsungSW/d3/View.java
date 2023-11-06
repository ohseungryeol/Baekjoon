package SamsungSW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=1; i<=10; i++){
            int n = Integer.parseInt(br.readLine());// 건물 갯수
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int answer=0;
            for (int k=2; k<n-2; k++){
                if(arr[k]>arr[k-1] && arr[k]>arr[k-2] && arr[k]>arr[k+1] && arr[k]>arr[k+2]){
                    int lt_max = Math.max(arr[k-1],arr[k-2]);
                    int rt_max = Math.max(arr[k+1],arr[k+2]);
                    int totalMax=Math.max(lt_max,rt_max);
                    answer+=arr[k]-totalMax;
                }
            }

            System.out.println("#"+i+" "+answer);
        }
    }
}
