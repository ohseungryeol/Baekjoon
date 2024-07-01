import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class boj1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑을 수 갯수

        Queue<Integer> seq = new LinkedList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();

        int last=0;
        for (int i=1; i<=N; i++){ // 1부터 N까지 넣기.
            linkedList.addLast(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++){
            seq.offer(Integer.parseInt(st.nextToken()));
        }

        int count=0;

        while(true){
            int mid = linkedList.size()/2;
            if(seq.isEmpty()) break;

            // 1 6 3 2 7 9 8 4 10 5
            if(linkedList.getFirst()==seq.peek()){
                linkedList.removeFirst();
                seq.poll();
                continue;
            }

            // 뽑아낼 수가 중간보다 앞에 있으면 왼쪽으로 이동
            if(linkedList.indexOf(seq.peek())<=mid){
                linkedList.addLast(linkedList.removeFirst());
                count++;
            // 중간보다 뒤면 오른쪽 이동.
            } else if (linkedList.indexOf(seq.peek())>mid){
                linkedList.addFirst(linkedList.removeLast());
                count++;
            }
        }

        System.out.println(count);
    }
}
