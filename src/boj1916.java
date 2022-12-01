import java.util.*;
import java.io.*;

public class boj1916 {
    private static final int INF = Integer.MAX_VALUE / 16;
    static List<ArrayList<Node>> list;
    static int dist[];
    static int N;

    static class Node implements Comparable<Node> {
        int nodeNum;
        int weight;

        public Node(int nodeNum, int weight) {
            this.nodeNum = nodeNum;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    } // End of Node

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수


        list = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());  //출발
            int d = Integer.parseInt(st.nextToken());  //도착
            int w = Integer.parseInt(st.nextToken()); // 비용


            list.get(s).add(new Node(d, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken()); //1번 출발 5번도착
        int destination = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, destination));

    } // End of main

    static int dijkstra(int start, int destination) {
        PriorityQueue<Node> que = new PriorityQueue<Node>();
        boolean visit[] = new boolean[N + 1];

        dist[start] = 0; //가중치 합
        que.offer(new Node(start, 0));

        while( !que.isEmpty() ) {
            Node queNode = que.poll();
            System.out.println(queNode.nodeNum+", "+queNode.weight);
            int start_nodeNum = queNode.nodeNum;

            if( !visit[start_nodeNum] ) {
                visit[start_nodeNum] = true;

                for(Node node : list.get(start_nodeNum)) {

                    if( !visit[node.nodeNum] && dist[node.nodeNum] > (dist[start_nodeNum] + node.weight) ) {
                        dist[node.nodeNum] = dist[start_nodeNum] + node.weight;
                        que.offer(new Node(node.nodeNum, dist[node.nodeNum]));
                    }
                }
            }
        }

        return dist[destination];
    } // End of dijkstra

} // End of Main class