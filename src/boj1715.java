import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class boj1715 {
    public static void main(String[] args) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        Scanner sc = new Scanner(System.in);
        long N= sc.nextLong();

        for (int i=0; i<N; i++){
            pq.add(sc.nextLong());
        }

        long sum =0;
        int result =0;
        long tmpSum =0;
        while(pq.size()>1){
            long num1 = pq.poll();
            long num2 = pq.poll();
            tmpSum =num1+num2;
            sum += tmpSum;
            pq.add(tmpSum);
        }

        System.out.println(sum);

    }
}
