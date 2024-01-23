import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2056 {
    static class Job implements Comparable<Job>{
        int num; //작업 번호
        int k;

        public Job(int num, int k) {
            this.num = num;
            this.k = k;
        }

        @Override
        public int compareTo(Job o) {
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k=0;
        int answer=0;
        int curK=0;
        StringTokenizer st;
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i=1; i<=N; i++){ // i=작업번호
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            //if(i==1) curK = time;


        }

        System.out.println(curK);

        /*
        1번작업: 0~5 k=5
        2번작업은 1초걸리고 1번이 선행조건 - 5~6  k=6
        3번작업은 3초걸리고 2번이 선행조건 6~9   k=9
        4번작업은 6초걸리고 1번이 선행조건 ( 5~11) k=11
        5번작업은 1초걸리고 2번 4번이 선행조건 , k= 6~7, 11~12   즉 k=12
        6번작업은 8초 걸리고 2번, 4번이 선행조건 k = 11~19,     즉 k= 19
        7번작업은 4초걸리고 선행조건이 3번 5번 6번 여기서 max = 19~ 23
ok

선행관계 없는걸 먼저 실행하자 일단 -> 동시 실행

        * */
    }
}
