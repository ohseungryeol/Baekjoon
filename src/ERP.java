import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ERP {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        int count =0;
        for (int i=0; i<tmp.length(); i++){
            if(tmp.charAt(i)==' '){
                count++;
            }
        }
        int memberShipNum = count+1; //참여한 응모권 수


        if(memberShipNum<n){ //당첨 수 보다 응모권 수가 적을 때(중복허용)
            StringTokenizer st = new StringTokenizer(tmp);
            HashSet<Integer> hashSet = new HashSet<>();
           for (int i=0; i<memberShipNum; i++){
               hashSet.add(Integer.valueOf(st.nextToken()));
           }
            ArrayList<Integer> answer = new ArrayList<>(hashSet);
            Collections.sort(answer, (o1,o2) -> o1 - o2); // 오름차순 정렬
            System.out.println(answer.toString());

        } else { //중복된 참가자는 아예 제거
            StringTokenizer st = new StringTokenizer(tmp);
            int[] numCount = new int[1001];
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i=0; i<memberShipNum; i++){
                int num = Integer.parseInt(st.nextToken());
                numCount[num]++;
            }

            st = new StringTokenizer(tmp);
            int[] answer = new int[n];
            int j=0;
            for (int i=0; i<memberShipNum; i++){
                int num = Integer.parseInt(st.nextToken());
                if(numCount[num]<=1){ //중복 회원이 아니라면 참가
                    answer[j++]=num;
                }
            }
            Arrays.sort(answer);
            System.out.println(Arrays.toString(answer));
        }
    }
}
