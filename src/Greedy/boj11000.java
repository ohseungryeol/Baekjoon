package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11000 {
    static class time implements Comparable<time> {
        int start,end;

        public time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(time o) {
            if(this.start==o.start){
                return this.end-o.end;
            } else{
                return this.start-o.start;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<time> arr = new ArrayList<>();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new time(start, end));
        }

        Collections.sort(arr);

        int cnt =1;
        int maxEnd = arr.get(0).end;
        for(int i=1; i<arr.size(); i++){
           if(arr.get(i).start>=maxEnd){
               maxEnd = arr.get(i).end;
               cnt++;
           }
        }

        System.out.println(cnt);
    }
}
