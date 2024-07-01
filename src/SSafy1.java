import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SSafy1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int T = Integer.parseInt(br.readLine());

        for (int test=1; test<=T; test++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[N];
            st = new StringTokenizer(br.readLine());

            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Collections.reverseOrder());
            int maxTeamNum =1;

            for (int i=0; i<N; i++){
                int pivot = arr[i];
                int myTeam=0;
                int last =0;
                for (int j=i; j<N; j++){
                    if(pivot-arr[j]<K){
                        myTeam++;
                    } else if (pivot - arr[j]==K){
                        last = arr[j];
                        myTeam++;
                    }
                    if(arr[j]<last) break;
                }
                maxTeamNum = Math.max(maxTeamNum,myTeam);
            }

            System.out.printf("#%d %d\n",test,maxTeamNum);
        }

    }
}
