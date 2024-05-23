package 다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달 {
    static ArrayList<Edge>[] graph = new ArrayList[51];
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static boolean[] visited = new boolean[51];
    static int[] dis = new int[51];
    static class Edge implements Comparable<Edge>{
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        Arrays.fill(dis,  Integer.MAX_VALUE);
        for (int i = 1; i <= 50; i++) graph[i] = new ArrayList<>();

        for (int[] edge:road){
            int s = edge[0];
            int e = edge[1];
            int w = edge[2];

            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s,w));
        }
        pq.offer(new Edge(1, 0));
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        Dijkstra(1);
        System.out.println(Arrays.toString(dis));
        for (int i=0; i<dis.length; i++) if(dis[i]<=K) answer++;
        System.out.println(answer);
        return answer;
    }

    public static void Dijkstra(int v){
        dis[v]=0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int next = cur.v;
            int w = cur.w;

            for (Edge edge : graph[cur.v]) {
                int nv = edge.v;
                int nw = edge. w;
                if(visited[nv] && dis[nv]<=dis[cur.v]+nw) continue; //이미 방문을 했고 현재 dis[nv]가 더 작으면 볼필요 x
                visited[nv]=true;
                if(dis[nv]>dis[cur.v]+nw) dis[nv] = dis[cur.v]+nw;

                pq.offer(new Edge(nv, nw));
            }
        }
    }
    public static void main(String[] args) {
        배달 main = new 배달();
        main.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
    }
}
