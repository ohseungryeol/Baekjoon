import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;

public class boj11723 {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String tmp = br.readLine();
            String[] str = tmp.split(" ");
            String cal = str[0];
            int num=0;
            if(str.length==2) num = Integer.parseInt(str[1]);

            if(cal.equals("all")){
                for(int j=1; j<=20; j++) set.add(j);
                continue;
            } else if (cal.equals("empty")){
                set.clear();
                continue;
            }
            switch (cal){
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    if(set.contains(num)) set.remove(num);
                    break;
                case "check":
                    if(set.contains(num)) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "toggle":
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
            }
        }
        /*
        *
        *
        *
        *
        *
        *
        *
        * */
    }
}
