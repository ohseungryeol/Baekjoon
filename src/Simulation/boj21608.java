package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj21608 {
    static int[][] map;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static PriorityQueue<Seat> pq = new PriorityQueue<>();

    static class Seat implements Comparable<Seat>{
        int x,y;
        int likeNum;
        int emptyNum;

        public Seat(int x, int y, int likeNum, int emptyNum) {
            this.x = x;
            this.y = y;
            this.likeNum = likeNum;
            this.emptyNum = emptyNum;
        }

        @Override
        public int compareTo(Seat o) {
            if(this.likeNum==o.likeNum) return o.emptyNum-this.emptyNum;
            if(this.likeNum==o.likeNum && this.emptyNum==o.emptyNum) return this.x-o.x;
            if(this.likeNum==o.likeNum && this.emptyNum==o.emptyNum && this.x==o.x) return this.y-o.y;

            return o.likeNum-this.likeNum; //1순위

        }
    }
    public static void main(String[] args) throws IOException {
        /*
        *
        1. 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 배정 (1개씩 4방향 탐색)
        2. 1 만족이 여러칸이면 인접한 칸중에서 비어있는 칸이 가장 많은 칸으로 (1 기준으로 탐색 )
        3. 2 만족도 여러개면 행의 번호가 가장 작은 칸으로 -> 열로
        *
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for (int i=0; i<N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();
            for (int j=0; j<4; j++){
                set.add(Integer.parseInt(st.nextToken()));
            }
            hm.put(num, set);
            findSeat(num, hm);
            pq.clear();
        }

        // 만족도 조사
        int answer =0;

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                int myNum = map[i][j];
                int likeCount=0;
                for (int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!isRange(nx,ny)) continue;
                    //4방에 좋아하는 친구가 있는가
                    if(hm.get(myNum).contains(map[nx][ny])) likeCount++;
                }

                if(likeCount==1) answer+=1;
                else if (likeCount==2) answer+=10;
                else if (likeCount==3) answer+=100;
                else if (likeCount==4) answer+=1000;
            }
        }

        System.out.println(answer);
    }

    public static void findSeat(int num, HashMap<Integer,HashSet<Integer>> hm){
        //1. 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 배정 (1개씩 4방향 탐색)

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                int emp =0;
                int like =0;
                if(map[i][j]!=0) continue; //이미 앉음
                for (int k=0; k<4; k++){ //한칸 한칸 모두 4방향 탐색
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!isRange(nx,ny)) continue;
                    if(hm.get(num).contains(map[nx][ny])) like++;
                    if(map[nx][ny]==0) emp++;
                }
                pq.add(new Seat(i, j, like, emp));
            }
        }

        Seat mySeat = pq.poll();
        map[mySeat.x][mySeat.y]=num;
    }

    public static boolean isRange(int nx, int ny){
        if(nx>=0 && nx<N && ny>=0 &&  ny<N) return true;
        return false;
    }

}
