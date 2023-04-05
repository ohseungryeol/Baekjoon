import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2564 {
    static class Point{
        int direct;
        int dis;

        public Point(int direct, int dis) {
            this.direct = direct;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine()); // 상점 갯수
        ArrayList<Point> loc = new ArrayList<>();

        for (int i=0; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            loc.add(new Point(dir, dis));
        }

        Point dong = loc.get(N); // 마지막 원소가 동근
        int answer =0;

        for (int i=0; i<N; i++){
            Point store = loc.get(i);
            switch(dong.direct){
                case 1: //북쪽
                    if(store.direct==1){
                        answer+=Math.abs(dong.dis-store.dis);
                    } else if (store.direct==2){
                        answer+=Math.min(dong.dis+height+store.dis, width-dong.dis +height+width-store.dis);
                    } else if (store.direct==3){
                        answer+=dong.dis+store.dis;
                    } else if (store.direct==4){
                        answer+=width-dong.dis+store.dis;
                    }
                    break;
                case 2: //남쪽
                    if(store.direct==2){
                        answer+=Math.abs(dong.dis-store.dis);
                    } else if (store.direct==1){
                        answer+=Math.min(dong.dis+height+store.dis, width-dong.dis +height+width-store.dis);
                    } else if (store.direct==3){
                        answer+=dong.dis+height-store.dis;
                    } else if (store.direct==4){
                        answer+=width-dong.dis+height-store.dis;
                    }
                    break;
                case 3: //서쪽
                    if(store.direct==3){
                        answer+=Math.abs(dong.dis-store.dis);
                    } else if (store.direct==1){
                        answer+=dong.dis+store.dis;
                    } else if (store.direct==2){
                        answer+=height-dong.dis+store.dis;
                    } else if (store.direct==4){
                        answer+=Math.min(dong.dis+width+store.dis, height-dong.dis+width+height-store.dis);
                    }
                    break;
                case 4: //동쪽
                    if(store.direct==4){
                        answer+=Math.abs(dong.dis-store.dis);
                    } else if (store.direct==1){
                        answer+=dong.dis+width-store.dis;
                    } else if (store.direct==2){
                        answer+=height-dong.dis+width-store.dis;
                    } else if (store.direct==3){
                        answer+=Math.min(dong.dis+width+store.dis, height-dong.dis+width+height-store.dis);
                    }
                    break;
            }
        }

        System.out.println(answer);

    }
}
