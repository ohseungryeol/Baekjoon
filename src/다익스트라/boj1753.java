package 다익스트라;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] dis;

    static class Edge implements Comparable<Edge>{
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점 갯수
        int E = Integer.parseInt(st.nextToken()); //간선 갯수
        dis = new int[V + 1]; // i번째 정점으로 가는 최단거리를 저장하는 배열

        int sV = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) graph.add(new ArrayList<Edge>());

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w)); //u에서 v까지 가는데 드는 비용(w)
        }
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[sV]=0;
        Dijkstra(sV,sb);
        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    public static void Dijkstra(int start,StringBuilder sb){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(dis[cur.v]<cur.cost) continue;
            for(Edge next:graph.get(cur.v)){
                if(dis[next.v]>cur.cost+next.cost){  //원래 저장된 최소거리보다 거쳐서온게 더 작다면 갱신
                    dis[next.v] = dis[cur.v]+ next.cost;
                }
                pq.offer(next);
            }
        }

        for (int i=1; i<=dis.length-1; i++){
            if(dis[i]== Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dis[i]+"\n");
        }
    }
}
