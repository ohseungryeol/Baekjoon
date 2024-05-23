import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj2866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> set = new HashSet<>();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] alpha = new char[R][C];

        for (int i=0; i<R; i++){
            String tmp = br.readLine(); //alfa beta zeta
            for (int j=0; j<C; j++){
                alpha[i][j] = tmp.charAt(j);
            }
        }
        int count=0;


        for (int i=0; i<C; i++){ // 열
            String str = "";
            for (int j=0; j<R; j++){ //행
                str += alpha[j][i];
            }
            // abz lee ftt aaa
            set.add(str);
        }

        // 맨 앞글자부터 차례로 지우기 .
        // 지우면서도 set에 추가
        // 1. 위의 행을 먼저지우고 봤을 때 문자열이 중복되는가 ?
        // 1-1 : 중복되는게 없다면 가장 위의 행을 지우고 count++
        // 1-2 : 종복되는게 있으면 종료 count출력


        Iterator<String> iter = set.iterator();
        HashSet<String> splSet = new HashSet<>();

        for (int i=0; i<R-1; i++ ) {
            while (iter.hasNext()) {
                String str = iter.next();
                String tmp = str;
                System.out.println(str);
                str = str.substring(1);

//            if(set.contains(str)){
//                System.out.println(count);
//                return;
//            } else {
//                set.add(str);
//            }
//
//            set.remove(tmp);
            }
        }

        // mmmm , rraa, vvrt, iiie, cccj, aaaa
        // mmm, raa, vrt, iie, ccj, aaa
        // mm, aa, rt, ie, cj, aa

    }
}
