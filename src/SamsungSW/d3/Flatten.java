package SamsungSW.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<=10; t++) {
            int dumpNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[100];

            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int minIdx = 0;
            int maxIdx = arr.length - 1;
            for (int i = 0; i < dumpNum; i++) {
                arr[minIdx]++;
                arr[maxIdx]--;
                Arrays.sort(arr);
            }
            System.out.printf("#%d %d\n",t,arr[maxIdx]-arr[minIdx]);
        }
    }
}
