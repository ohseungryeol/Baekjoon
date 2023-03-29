package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int A_SIZE = Integer.parseInt(st.nextToken());
        int B_SIZE = Integer.parseInt(st.nextToken());
        int[] A = new int[A_SIZE];
        int[] B = new int[B_SIZE];
        int[] answer = new int[A_SIZE+B_SIZE];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<A_SIZE; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<B_SIZE; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int p1=0;
        int p2=0;
        int i=0;
        while(p1<A_SIZE && p2<B_SIZE){
            if(A[p1]<=B[p2]){
                sb.append(A[p1++]).append(" ");
            } else{
                sb.append(B[p2++]).append(" ");
            }
        }

        if(p1>=A_SIZE){
            while(p2<B_SIZE){
                sb.append(B[p2++]).append(" ");
            }
        } else if (p2>=B_SIZE){
            while(p1<A_SIZE){
                sb.append(A[p1++]).append(" ");
            }
        }

        System.out.println(sb);


    }
}
