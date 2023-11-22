package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916 {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] dis;
    static class Edge implements Comparable<Edge>{
        int num; //정점번호
        int cost;

        public Edge(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //정점 갯수
        int E = Integer.parseInt(br.readLine()); //간선 갯수

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<Edge>());

        for (int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, e));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start]=0;
        Dijkstra(start);
        System.out.println(dis[end]);
    }

    public static void Dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(dis[cur.num]<cur.cost) continue;
            for (Edge next:graph.get(cur.num)){
                if(dis[next.num]>cur.cost+next.cost){
                    dis[next.num] = cur.cost+next.cost;
                    pq.offer(new Edge(next.num,dis[next.num]));
                }

            }
        }
    }
}
