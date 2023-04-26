package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//도시 갯수
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        int[] distance = new int[N - 1]; //거리
        int[] arr = new int[N]; // 1L당 가격

        int min = Integer.MAX_VALUE;
        int totalDistance=0;
        for (int i=0; i<N-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
            totalDistance+=distance[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==N-1) break;
            if(min>arr[i]) min=arr[i];
        }

        long answer= 0;
        for (int i=0; i<N-1; i++){
            if(arr[i]==min){
                answer+=arr[i]*totalDistance;
                break;
            } else{
                answer+=arr[i]*distance[i];
                totalDistance-=distance[i];
            }
        }

        System.out.println(answer);



    }
}
