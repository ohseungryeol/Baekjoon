import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj18258 {
    static int last =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            String tmp = br.readLine();
            if (tmp.contains(" ")){
                String[] str = tmp.split(" ");
                last = Integer.parseInt(str[1]);
                queue.offer(last);
            } else if (tmp.contains("pop")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else if (tmp.contains("size")) {
                sb.append(queue.size()).append("\n");
            } else if (tmp.contains("empty")){
                if (queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (tmp.contains("front")){
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            } else if (tmp.contains("back")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(last).append("\n");
            }
        }


        System.out.print(sb);
    }
}
