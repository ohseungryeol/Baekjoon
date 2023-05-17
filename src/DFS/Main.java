package DFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    int[] dis;
    int[] dx = {2,1,-1};
    boolean[] visited;
    int min = Integer.MAX_VALUE;
    static int N,K;
    public void process(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //수빈 위치
        K = sc.nextInt(); //동생 위치
        dis = new int[100001];
        visited = new boolean[100001];
        BFS(N);
    }

    public void BFS(int N){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(N));

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            visited[tmp.x]=true;
            if(tmp.x==K){
                min = Math.min(min,dis[tmp.x]);
            }
            int nx=-1;
            for (int i=0; i<3; i++){
                if(i==0){
                    nx = tmp.x*dx[0];
                } else {
                    nx = tmp.x+dx[i];
                }

                if(nx>=0 && nx<=100000 && !visited[nx]){
                    queue.offer(new Point(nx));
                    visited[nx]=true;
                    if(i==1 || i==2){
                        dis[nx]+=dis[tmp.x]+1;
                    } else{
                        dis[nx]=dis[tmp.x];
                    }

                }

            }
        }

    }
    public static void main(String[] args) {
        Main bo = new Main();
        bo.process();
        System.out.println(bo.min);
    }
}

class Point{
    int x;
    public Point(int x) {
        this.x = x;
    }
}
