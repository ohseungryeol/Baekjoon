import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //벨트 위 접시 수
        int d = Integer.parseInt(st.nextToken()); //총 가짓 수
        int k = Integer.parseInt(st.nextToken()); //연속 수
        int bonus = Integer.parseInt(st.nextToken());
        int answer=1;
        int[] Sushi = new int[N];
        for (int i=0; i<N; i++){
            Sushi[i] = Integer.parseInt(br.readLine());
        }
        // System.out.println(Arrays.toString(Sushi));
        for (int i=0; i<=N-k; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
               // System.out.print(Sushi[j]+" ");
                set.add(Sushi[j]);
            }

            // k개를 연속으로 먹었을 경우.
            if(!set.contains(bonus)) answer = Math.max(answer,set.size()+1);
            else answer = Math.max(answer,set.size());
        }

        System.out.println(answer);
        /*
        * 1. k개 접시를 연속해서 먹으면 할인행사
          2. 초밥번호 쿠폰 -> 할인 행사에 참가하면 해당번호 초밥 무료
          3. 현재 벨트안에 없어도 제공
          * 먹을 수 있는 최대 종류 갯수는 ?
          * - 보너스를 받는 것이 무조건 유리. 겹치지 않는 초밥을 받는 것이 유리.
          *
        * */
    }
}
